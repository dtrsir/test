package com.zhong.service.role;

import com.zhong.dao.role.RoleMapper;
import com.zhong.pojo.Role;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleServiceImpl implements RoleService{

    //查询角色列表
    public List<Role> queryRole() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.getRoleList();
        sqlSession.close();
        return roleList;
    }


    //通过id获取角色
    public Role getRoleById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.getById(id);
        sqlSession.close();
        return role;
    }



}
