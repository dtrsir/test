package com.zhong.service.user;

import com.zhong.Utils.PageSupport;
import com.zhong.dao.user.UserMapper;
import com.zhong.pojo.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /*条件查询用户（查询所有用户）展示所有用户。
    展示条件查询用户:角色，姓名，年龄:starDate， endDate，性别。
    分页：from，pageSize*/
    public List<User> queryUser(Map map) {
        List<User> userList = userMapper.queryUser(map);
        return userList;
    }

    //用户登陆
    public User getLoginUser(String userCode) {
        return userMapper.getLoginUser(userCode);
    }

    //统计用户数
    public int userCount(Map map) {
        return userMapper.userCount(map);
    }

    //添加一个用户
    @Override
    public boolean addUser(User user) {
        int row = userMapper.addUser(user);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //删除一个用户
    @Override
    public boolean deleteUser(int userId) {
        int row = userMapper.deleteUser(userId);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //通过id查找用户
    @Override
    public User getUserById(int id) {
        User user = userMapper.getUser(id);
        return user;
    }

    //修改用户
    @Override
    public boolean modifyUser(User user) {
        int row = userMapper.updateUser(user);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

    //修改当前用户密码
    @Override
    public boolean modifyPassword(int id, String password) {
        int row = userMapper.updatePassword(id, password);
        if (row > 0) {
            return true;
        }else {
            return false;
        }
    }

}
