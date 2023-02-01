package com.zhong.service.book;

import com.zhong.dao.book.BookMapper;
import com.zhong.pojo.Book;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> queryBook(Map map) {
        return bookMapper.queryBook(map);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookMapper.getBookById(bookId);
    }

    @Override
    public List<Book> bookList() {
        return bookMapper.bookList();
    }

    @Override
    public boolean addBook(Book book) {
        int i = bookMapper.addBook(book);
        if (i > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteBook(int bookId) {
        int i = bookMapper.deleteBook(bookId);
        if (i > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean borrowBook(int bookId) {
        int i = bookMapper.borrowBook(bookId);
        if (i > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean revertBook(int bookId) {
        int i = bookMapper.revertBook(bookId);
        if (i > 0) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        int i = bookMapper.updateBook(book);
        if (i > 0) {
            return true;
        }else {
            return false;
        }
    }
}
