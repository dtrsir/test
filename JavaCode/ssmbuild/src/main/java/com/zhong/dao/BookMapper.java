package com.zhong.dao;

import com.zhong.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookMapper {

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("id") int id);

    //修改一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBook(Map map);

    //查询一本书
    Books queryBookById(@Param("id") int id);

    //查询所有书
    List<Books> queryAllBook();

    //统计书
    int countBook(Map map);
}
