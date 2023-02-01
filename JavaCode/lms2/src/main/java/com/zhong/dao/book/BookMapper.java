package com.zhong.dao.book;

import com.zhong.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    /*条件查询书籍*/
    List<Book> queryBook(Map map);

    /*通过id获取书籍*/
    Book getBookById(@Param("id") int bookId);

    //显示所有的图书
    List<Book> bookList();

    //增加一本图书
    int addBook(Book book);

    //删除一本图书
    int deleteBook(@Param("id") int bookId);

    //借阅一本图书
    int borrowBook(@Param("id") int bookId);

    //归还一本图书
    int revertBook(@Param("id") int bookId);

    //修改一本图书
    int updateBook(Book book);
}
