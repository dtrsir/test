package com.zhong.controller;


import com.zhong.pojo.Books;
import com.zhong.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;


    @RequestMapping("/allBook")
    public String list(Model model) {

        List<Books> books = bookService.queryAllBook();
        model.addAttribute("bookList",books);
        return "allBook";
    }

/*    //请求跳转RestFul风格
    @RequestMapping("/{id}")
    public String page(@PathVariable("id") String page) {
        return page;
    }*/

    @RequestMapping("/toAddBook")
    public String addBookPage() {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdatePage/{bookID}")
    public String updateBookPage(@PathVariable("bookID") int bookId, Model model) {
        Books book = bookService.queryBookById(bookId);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int bookID) {
        bookService.deleteBookById(bookID);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        HashMap map = new HashMap();
        map.put("bookName", queryBookName);
        Books book = bookService.queryBook(map);
        List<Books> books = new ArrayList<Books>();
        books.add(book);
        model.addAttribute("bookList",books);

        return "allBook";
    }
}
