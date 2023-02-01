package dao.role;

import org.apache.ibatis.annotations.Param;
import pojo.Role;

import java.util.List;

public interface RoleMapper {
    //获取角色列表
    public List<Role> getRoleList();

    //增加角色信息
    public int add(Role role);

    //通过Id删除Role
    public int deleteRoleById(@Param("id") Integer delId);

    //修改角色信息
    public int modify(Role role);

    //通过Id获取role
    public Role getRoleById(@Param("id") Integer id);

    //根据roleCode，进行角色编码的唯一性验证
    public int roleCodeIsExist(@Param("roleCode") String roleCode);

}
