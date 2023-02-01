package com.zhong.service.role;

import com.zhong.dao.BaseDao;
import com.zhong.dao.role.RoleDao;
import com.zhong.dao.role.RoleDaoImpl;
import com.zhong.pojo.Role;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    //引入dao层
    private RoleDao roleDao = null;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    //获取角色列表
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }

}
