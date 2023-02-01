package com.zhong.dao.role;

import com.zhong.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    //获取角色列表
    List<Role> getRoleList();

    //根据id获取角色
    Role getById(@Param("id") int id);

    //增加角色
    int addRole(Role role);

    //通过id删除角色
    int deleteRole(@Param("id") int id);

    //修改角色
    int modify(Role role);
}
