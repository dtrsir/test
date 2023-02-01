package com.tsgl.service.impl;

import com.tsgl.dao.BookShelfDao;
import com.tsgl.dao.impl.BookShelfDaoImpl;
import com.tsgl.pojo.BookShelf;
import com.tsgl.service.BookShelfService;

import java.util.List;


public class BookShelfServiceImpl implements BookShelfService {

    private BookShelfDao bookShelfDao = new BookShelfDaoImpl();

    @Override
    public List<BookShelf> selectBookShelf(Integer userid) {
        return bookShelfDao.selectBookShelf(userid);
    }

    @Override
    public boolean addBookShelf(BookShelf bookShelf) {
        return bookShelfDao.addBookShelf(bookShelf);
    }

    @Override
    public boolean removeBookShelf(Integer userid, Integer bookid) {
        return bookShelfDao.removeBookShelf(userid,bookid);
    }
}
