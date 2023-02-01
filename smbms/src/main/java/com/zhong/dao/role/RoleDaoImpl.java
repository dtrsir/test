package com.zhong.dao.role;

import com.zhong.dao.BaseDao;
import com.zhong.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    //查询用户列表
    public List<Role> getRoleList(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Role> roleList = new ArrayList<Role>();

        if (connection!=null) {
            String sql = "select * from smbms_role";
            Object[] param = {};
            resultSet = BaseDao.executeQuery(connection, resultSet, preparedStatement, sql, param);



            while (resultSet.next()) {
                Role _role = new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRoleCode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                roleList.add(_role);
            }
            BaseDao.closeResource(null, resultSet,preparedStatement);
        }
        return roleList;
    }
}
