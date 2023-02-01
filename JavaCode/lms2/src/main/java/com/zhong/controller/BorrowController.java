package com.zhong.controller;

import com.zhong.Utils.Constants;
import com.zhong.Utils.PageSupport;
import com.zhong.pojo.Book;
import com.zhong.pojo.Borrow;
import com.zhong.pojo.User;
import com.zhong.service.book.BookService;
import com.zhong.service.borrow.BorrowService;
import com.zhong.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    @Qualifier("borrowService")
    private BorrowService borrowService;



    @RequestMapping("/borrowList")
    public String borrowList(HttpServletRequest request, Model model) throws ParseException {
        String flag = (String) request.getAttribute("flag");
        if (request.getAttribute("borrowList") != null && !("query".equals(flag))) {
            return "borrowList";
        }

        HashMap map = new HashMap();

        String queryBookName =  request.getParameter( "queryBookName");
        String queryUserCode = request.getParameter("queryUserCode");
        String starDate = request.getParameter("starDate");
        String endDate = request.getParameter("endDate");
        String pageIndex = request.getParameter("pageIndex");


        //设置分页
        int pageSize = Constants.PAGE_SIZE;//一般在实际应用中会写到配置文件中方便后期修改
        int currentPageNo = 1;

        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数
        int totalCount = userService.userCount(map);//userName, userRole
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }




        List<Borrow> borrowList = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (flag != null && flag.equals("query")) {
            map.put("bookName", queryBookName);
            map.put("userCode", queryUserCode);
            List<Book> books = bookService.queryBook(map);
            List<User> users = userService.queryUser(map);
            Integer userId = null;
            LinkedHashSet<Integer> bookId = new LinkedHashSet<Integer>();
            borrowList = new ArrayList<Borrow>();

            if (starDate != null && !(starDate.equals(""))) {
                starDate = simpleDateFormat.format(starDate);
                map.put("starBorrowDate", starDate);
            }
            if (endDate != null && !(endDate.equals(""))) {
                endDate = simpleDateFormat.format(endDate);
                map.put("endBorrowDate", endDate);
            }
            if (users != null && books == null) {
                userId = users.get(0).getId();
                map.put("userId", userId);
                map.put("from",(currentPageNo - 1) * pageSize);
                map.put("pageSize",pageSize);
                List<Borrow> borrows = borrowService.queryBorrow(map);
                borrowList.addAll(borrows);
            }
            if (books != null) {
                for (Book book : books) {
                    bookId.add(book.getId());
                }
                Iterator iterator = bookId.iterator();
                while (iterator.hasNext()) {
                    Integer next = (Integer) iterator.next();
                    map.put("bookId", next);
                    if (users != null) {
                        map.put("userId", userId);
                    }
                    map.put("from",(currentPageNo - 1) * pageSize);
                    map.put("pageSize",pageSize);
                    List<Borrow> borrows = borrowService.queryBorrow(map);
                    borrowList.addAll(borrows);
                }
            }
        }

        if (flag == null || !flag.equals("query")) {
            map.put("from",(currentPageNo - 1) * pageSize);
            map.put("pageSize",pageSize);
            borrowList = borrowService.queryBorrow(map);
        }
        for (Borrow borrow : borrowList) {
            borrow.setUserName(userService.getUserById(borrow.getUserId()).getUserName());
            borrow.setBookName(bookService.getBookById(borrow.getBookId()).getBookName());
            if (borrow.getRevertDate() != null) {
                borrow.setRevertDate(simpleDateFormat.parse(simpleDateFormat.format(borrow.getRevertDate())));
            }
            borrow.setBorrowDate(simpleDateFormat.parse(simpleDateFormat.format(borrow.getBorrowDate())));
        }

        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        /*搜索框数据保持*/
        model.addAttribute("queryBookName",queryBookName);
        model.addAttribute("queryUserCode",queryUserCode);
        model.addAttribute("starDate",starDate);
        model.addAttribute("endDate",endDate);
        /**/
        model.addAttribute("borrowList", borrowList);
        return "borrowList";

    }
}
