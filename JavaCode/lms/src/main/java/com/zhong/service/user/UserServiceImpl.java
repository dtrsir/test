package com.zhong.service.user;

import com.zhong.dao.role.RoleMapper;
import com.zhong.dao.user.UserMapper;
import com.zhong.pojo.Role;
import com.zhong.pojo.User;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    //登陆
    public User login(String userCode, String pwd) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUserCode(userCode);//如果找不到userCode，那么user为null
        sqlSession.close();

        if (user != null) {//userCode存在
            String password = user.getPassword();
            if (!password.equals(pwd)) {
                return null;//登陆失败
            }else {
                return user;//登陆成功
            }
        }
        return null;
    }

    //修改当前用户密码
    public boolean updatePwd(int id, String pwd) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(id, pwd);
        sqlSession.commit();
        sqlSession.close();
        if (i > 0) {//修改成功
            return true;
        }else {//修改失败
            return false;
        }
    }

    //查询用户
    public List<User> queryUser(Map map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList(map);
        sqlSession.close();
        return userList;
    }

    //条件统计用户数
    public int getUserCount(Map map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userCount = mapper.getUserCount(map);
        sqlSession.close();
        return userCount;
    }

    //添加一个用户
    public boolean addUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
        if (i > 0) {
            return true;
        }else {
            return  false;
        }
    }

    //通过id获得一个user对象
    public User getUserByID(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(id);
        int year = user.getBirthday().getYear();
        user.setAge(new Date().getYear() - year);
        RoleMapper mapper1 = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper1.getById(user.getUserRole());
        user.setRoleName(role.getRoleName());
        sqlSession.close();
        return user;
    }

    //修改一个对象
    public boolean modify(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int modify = mapper.modify(user);
        sqlSession.commit();
        sqlSession.close();
        if (modify>0){
            return true;
        }else {
            return false;
        }
    }

    //删除一个用户
    public Boolean deleteById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
        if (i>0) {
            return true;
        }else {
            return false;
        }
    }


}
