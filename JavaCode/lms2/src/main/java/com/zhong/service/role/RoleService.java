package com.zhong.service.role;

import com.zhong.pojo.Role;

import java.util.List;

public interface RoleService {

    //根据id查询用户角色
    Role queryRole(int id);

    //查询角色列表
    List<Role> roleList();
}
