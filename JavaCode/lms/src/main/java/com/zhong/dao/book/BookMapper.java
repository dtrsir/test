package com.zhong.dao.book;

import com.zhong.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookMapper {

    //通过图书id获取图书信息
    Book getBookById(@Param("id") int id);

    //通过条件查询图书(通过map传递参数)。 书名，作者，出版社，库存（分页currentPageNo和PageSize）
    List<Book> getBookList(Map map);

    //通过条件统计图书数量。作者，出版社，库存
    int getBookCount(Map map);

    //查询某一个时间段内出版的图书
    List<Book> getBookByPublicTime(@Param("starTime") Date starTime,
                                   @Param("endTime") Date endTime,
                                   @Param("currentPageNo")int currentPageNo,
                                   @Param("pageSize")int pageSize);

    //添加图书
    int addBook(Book book);

    //通过id删除图书
    int deleteBook(@Param("id") int id);

    //修改图书信息
    int modify(Book book);



}
