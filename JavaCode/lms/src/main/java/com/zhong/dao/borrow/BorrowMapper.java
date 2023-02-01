package com.zhong.dao.borrow;

import com.zhong.pojo.Borrow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {

    //条件查询借阅记录(读者查自己，系统管理员查所有记录,业务层读者要传userId，系统管理员不传)
    List<Borrow> getBorrowList(Map map);

    //统计在借书籍
    int getBorrowCount(@Param("id") int userId);

    //可借阅数量（10本）此处不实现，在业务层实现调用在借图书用10减去得结果

    //增加借阅记录
    int addBorrow(Borrow borrow);

    //通过id删除借阅记录
    int deleteBorrowById(@Param("id")int id);

    //修改借阅记录
    int modify(Borrow borrow);
}
