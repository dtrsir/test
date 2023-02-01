package com.zhong.service.book;

import com.zhong.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookService {

    /*条件查询书籍*/
    List<Book> queryBook(Map map);

    /*通过id获得书籍*/
    Book getBookById(int bookId);

    //显示所有的图书
    List<Book> bookList();

    //增加一本图书
    boolean addBook(Book book);

    //删除一本图书
    boolean deleteBook(int bookId);

    //借阅一本图书
    boolean borrowBook(int bookId);

    //归还一本图书
    boolean revertBook(int bookId);

    //修改一本图书
    boolean updateBook(Book book);
}
