package com.zhong.dao.borrow;

import com.zhong.pojo.Borrow;

import java.util.List;
import java.util.Map;

public interface BorrowMapper {

    //增加一条借阅记录
    int addBorrow(Borrow borrow);

    //删除一条借阅记录
    int deleteBorrow(int id);

    //修改一条借阅记录
    int updateBorrow(Borrow borrow);


    //查询所有借阅记录
    List<Borrow> borrowList(Integer userId);

    //根据用户id查询借阅记录，根据书籍id查询，根据记录id查询
    //条件查询借阅记录
    List<Borrow> queryBorrow(Map map);

    //统计借阅记录
    //根据条件统计借阅记录
    int countBorrow(Map map);
    //
}
