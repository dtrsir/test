package com.zhong.service.borrow;

import com.zhong.pojo.Borrow;

import java.util.List;

public interface BorrowService {

    //查询借阅列表
    List<Borrow> getBorrowList(int uid);

    //查询用户在借图书数量
    int getBorrowCount(int uid);

    //查询用户可借图书数量
    int getBorrowBook(int uid);

    //增加一条借阅记录
    boolean addBorrow();

    //删除一条借阅记录
    boolean deleteBorrow();

    //修改一条借阅记录
    boolean modifyBorrow();

}
