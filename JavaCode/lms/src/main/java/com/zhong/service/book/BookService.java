package com.zhong.service.book;

import com.zhong.pojo.Book;

import java.util.List;

public interface BookService {

    //获取图书列表
    List<Book> getBookList();

    //根据条件查询图书
    Book getBook();

    //增加一本图书
    boolean addBook();

    //删除一本图书
    boolean deleteBook();

    //对图书的信息进行更新
    boolean modifyBook();

    //查询图书的种类
    int getBookCount();

    //查询图书库存
    int getBookStock();


}
