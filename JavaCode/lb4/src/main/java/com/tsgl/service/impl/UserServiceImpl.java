package com.tsgl.service.impl;

import com.tsgl.dao.UserDao;
import com.tsgl.dao.impl.UserDaoImpl;
import com.tsgl.pojo.User;
import com.tsgl.service.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {

    // 定义dao对象
    private UserDao userDao = new UserDaoImpl();

    //查询用户信息
    
    @Override
    public List<User> selectUser(String username) {

        StringBuffer sql = new StringBuffer("select * from user where 1 = 1 ");
        List<Object> list = new ArrayList<Object>();
        if(username != null){

            sql.append(" and username = ?");
            list.add(username);
        }
        // 交给dao层处理逻辑
        return userDao.selectUser(sql.toString(),list.toArray());
    }

    @Override
    public User getUser(Integer userid) {
        return userDao.getUser(userid);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(Integer userid) {
        return userDao.deleteUser(userid);
    }
}
