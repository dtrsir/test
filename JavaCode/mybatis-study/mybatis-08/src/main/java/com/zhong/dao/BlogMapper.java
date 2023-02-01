package com.zhong.dao;

import com.zhong.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBook(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);


    //查询博客
    List<Blog> queryBlogChoose(Map map);




    int updateBlog(Map map);

    //查询1 2 3号博客
    List<Blog> queryBlogForeach(Map map);




}
