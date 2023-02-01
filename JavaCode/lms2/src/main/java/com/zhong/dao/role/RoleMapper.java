package com.zhong.dao.role;

import com.zhong.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    //根据id查询角色
    Role queryRole(@Param("id") int roleId);

    //查询角色列表
    List<Role> roleList();
}
