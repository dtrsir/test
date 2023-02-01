package com.tsgl.dao;

import java.util.List;

import com.tsgl.pojo.Comment;


public interface CommentDao {

    //添加留言
  
    public boolean addComment(Comment comment);

   //展示留言
   
    public List<Comment> selectComment(Integer bookid);
}
