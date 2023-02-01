package com.zhong.service;

import com.zhong.dao.BookMapper;
import com.zhong.pojo.Books;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService{

    //组合dao层
    private BookMapper bookMapper;

    //spring直接注入
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBook(Map map) {
        return bookMapper.queryBook(map);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public int countBook(Map map) {
        return 0;
    }
}
