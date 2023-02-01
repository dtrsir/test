package com.zhong.service.borrow;

import com.zhong.dao.borrow.BorrowMapper;
import com.zhong.pojo.Borrow;

import java.util.List;
import java.util.Map;

public class BorrowServiceImpl implements BorrowService {
    private BorrowMapper borrowMapper;

    public void setBorrowMapper(BorrowMapper borrowMapper) {
        this.borrowMapper = borrowMapper;
    }

    //增加一条借阅记录
    @Override
    public boolean addBorrow(Borrow borrow) {
        int row = borrowMapper.addBorrow(borrow);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //删除一条借阅记录
    @Override
    public boolean deleteBorrow(int id) {
        int row = borrowMapper.deleteBorrow(id);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //修改一条借阅记录
    @Override
    public boolean updateBorrow(Borrow borrow) {
        int row = borrowMapper.updateBorrow(borrow);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //查询所有借阅记录
    @Override
    public List<Borrow> borrowList(Integer userId) {
        List<Borrow> borrows = borrowMapper.borrowList(userId);
        return borrows;
    }

    //根据用户id查询借阅记录，根据书籍id查询，根据记录id查询
    //条件查询借阅记录
    @Override
    public List<Borrow> queryBorrow(Map map) {
        List<Borrow> borrows = borrowMapper.queryBorrow(map);
        return borrows;
    }

    @Override
    public int countBorrow(Map map) {
        int i = borrowMapper.countBorrow(map);
        return i;
    }
}
