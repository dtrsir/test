package com.tsgl.dao;

import java.util.List;

import com.tsgl.pojo.BookShelf;

//数据交互层接口
public interface BookShelfDao {


    //搜索
    
    public List<BookShelf> selectBookShelf(Integer userid);


    //加入图书到书架
     
    public boolean addBookShelf(BookShelf bookShelf);


    //从书架中删除图书
     
    public boolean removeBookShelf(Integer userid,Integer bookid);
}
