package com.zhong.service.role;

import com.zhong.pojo.Role;

import java.util.List;

public interface RoleService {

    //查询全部角色
    List<Role> queryRole();

    //通过id获取角色
    Role getRoleById(int id);
}
