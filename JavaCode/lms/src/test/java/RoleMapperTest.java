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
        System.out.println("=========================");
        for (Role role : roleList) {
            System.out.println(role);
        }
        System.out.println("=========================");
        sqlSession.close();
    }

    //根据id获取角色
    @Test
    public void getByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = mapper.getById(1);
        System.out.println("==================================");
        System.out.println(role);
        System.out.println("==================================");
        sqlSession.close();
    }

    //增加角色
    @Test
    public void addRoleTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role(4, "test", 100, 1, new Date(), null, null);
        int row = mapper.addRole(role);
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

    //通过id删除角色
    @Test
    public void deleteRoleTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        int row = mapper.deleteRole(4);
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

    //修改角色
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        Role role = new Role(4, null, null, null, null, 1, new Date());
        int row = mapper.modify(role);
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

}
