package com.zhong.service.role;

import com.zhong.dao.role.RoleMapper;
import com.zhong.pojo.Role;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public Role queryRole(int id) {
        return roleMapper.queryRole(id);
    }

    public List<Role> roleList() {
        return roleMapper.roleList();
    }
}
