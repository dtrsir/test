package com.tsgl.service.impl;

import com.tsgl.dao.CommentDao;
import com.tsgl.dao.impl.CommentDaoImpl;
import com.tsgl.pojo.Comment;
import com.tsgl.service.CommentService;

import java.util.List;


public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao = new CommentDaoImpl();


    @Override
    public boolean addComment(Comment comment) {
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> selectComment(Integer bookid) {
        return commentDao.selectComment(bookid);
    }
}
