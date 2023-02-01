package com.zhong.controller;

import com.zhong.service.book.BookService;
import com.zhong.service.borrow.BorrowService;
import com.zhong.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @Autowired
    @Qualifier("borrowService")
    private BorrowService borrowService;

    @RequestMapping("/bookList")
    public String bookList() {
        return "bookList";
    }
}
