import com.zhong.dao.role.RoleMapper;
import com.zhong.pojo.Role;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class RoleMapperTest {

    //获取角色列表
    @Test
    public void getRoleListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.getRoleList();
        for (Role role : roleList) {
            System.out.println(role);
        }

        sqlSession.close();
    }

    //增加角色信息
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Date date = new Date();
        int row = mapper.add(new Role(4, "TEST", "测试员工", 1, date, null, null));

        if (row > 0) {
            System.out.println("================================");
            System.out.println("insert success!!!");
            System.out.println("================================");
        }else {
            System.out.println("================================");
            System.out.println("insert fail!!!");
            System.out.println("================================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //通过Id删除Role
    @Test
    public void deleteRoleByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int row = mapper.deleteRoleById(4);

        if (row > 0) {
            System.out.println("================================");
            System.out.println("delete success!!!");
            System.out.println("================================");
        }else {
            System.out.println("================================");
            System.out.println("delete fail!!!");
            System.out.println("================================");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    //修改角色信息
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Date date = new Date();
        int row = mapper.modify(new Role(4, null, null, null, null, 1, date));

        if (row > 0) {
            System.out.println("================================");
            System.out.println("modify success!!!");
            System.out.println("================================");
        }else {
            System.out.println("================================");
            System.out.println("modify fail!!!");
            System.out.println("================================");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    //通过Id获取role
    @Test
    public void getRoleByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role roleById = mapper.getRoleById(4);
        System.out.println(roleById);

        sqlSession.close();
    }

    //根据roleCode，进行角色编码的唯一性验证
    @Test
    public void roleCodeIsExistTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int row = mapper.roleCodeIsExist("TEST");
        if (row == 1) {
            System.out.println("========================");
            System.out.println("only!");
            System.out.println("========================");
        }else {
            System.out.println("========================");
            System.out.println("no only!");
            System.out.println("========================");
        }
        sqlSession.close();
    }
}
