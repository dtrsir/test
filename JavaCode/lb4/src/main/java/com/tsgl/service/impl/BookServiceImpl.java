package com.tsgl.service.impl;

import com.tsgl.dao.BookDao;
import com.tsgl.dao.impl.BookDaoImpl;
import com.tsgl.pojo.Book;
import com.tsgl.service.BookService;

import java.util.ArrayList;
import java.util.List;

//Book的Service实现层

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    // 按照书籍名查询图书信息
   
    @Override
    public List<Book> select(String bookname) {
        StringBuffer sql = new StringBuffer("select * from book where 1 = 1 ");
        List<Object> list = new ArrayList<Object>();
        if(bookname != null){
            sql.append(" and bookname = ?");
            list.add(bookname);

        }
        return bookDao.select(sql.toString(),list.toArray());
    }

    @Override
    public Book getBook(Integer bookid) {
        return bookDao.getBook(bookid);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean deleteBook(Integer bookid) {
        return bookDao.deleteBook(bookid);
    }


}
