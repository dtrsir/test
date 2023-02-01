import com.zhong.dao.provide.ProviderMapper;
import com.zhong.pojo.Provider;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ProviderMapperTest {


    //增加用户信息
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Date time = new Date();
        int row = mapper.add(new Provider(16, "ZJ_GYS002", "可口可乐有限公司", "长期合作伙伴，主营产品：各种口味的可口可乐", "钟离", "13212331567", "广东省金广州市增城区XXXX", "0579-34452321", 1, time, null, null));

        if (row > 0) {
            System.out.println("=============================");
            System.out.println("insert success!");
            System.out.println("=============================");
        }else {
            System.out.println("=============================");
            System.out.println("insert fail!");
            System.out.println("=============================");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    //通过条件查询providerList
    @Test
    public void getProviderListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> providerList = mapper.getProviderList(null, null, 0, 5);
        for (Provider provider : providerList) {
            System.out.println(provider);
        }

        sqlSession.close();
    }

    //获取供应商列表
    @Test
    public void getProListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        List<Provider> proList = mapper.getProList();
        for (Provider provider : proList) {
            System.out.println(proList);
        }
        sqlSession.close();
    }

    //通过条件查询供应商记录数
    @Test
    public void getProviderCountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int row = mapper.getProviderCount(null, null);
        System.out.println("=======================");
        System.out.println("根据条件查询到的供应商数为：" + row);
        System.out.println("=======================");

        sqlSession.close();
    }

    //通过供应商Id删除供应商信息
    @Test
    public void deleteProviderByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        int row = mapper.deleteProviderById(16);

        if (row > 0) {
            System.out.println("======================");
            System.out.println("delete success!!!");
            System.out.println("======================");
        }else {
            System.out.println("======================");
            System.out.println("delete fail!!!");
            System.out.println("======================");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    //根据供应商Id获取供应商信息
    @Test
    public void getProviderByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Provider providerById = mapper.getProviderById(15);
        System.out.println(providerById);
        sqlSession.close();
    }

    //修改供应商
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ProviderMapper mapper = sqlSession.getMapper(ProviderMapper.class);
        Date date = new Date();
        Provider provider = new Provider(16, null, null, null, null, null, null, null, null, null, 1, date);
        int row = mapper.modify(provider);

        if (row > 0) {
            System.out.println("======================");
            System.out.println("delete success!!!");
            System.out.println("======================");
        }else {
            System.out.println("======================");
            System.out.println("delete fail!!!");
            System.out.println("======================");
        }


        sqlSession.commit();
        sqlSession.close();
    }

}
