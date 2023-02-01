import com.zhong.dao.borrow.BorrowMapper;
import com.zhong.pojo.Borrow;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BorrowMapperTest {

    //条件查询借阅记录(读者查自己，系统管理员查所有记录,业务层读者要传userId，系统管理员不传)
    @Test
    public void getBorrowListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
        HashMap map = new HashMap();
//        map.put("userId", 3);

        List<Borrow> borrowList = mapper.getBorrowList(map);
        System.out.println("===================================");
        for (Borrow borrow : borrowList) {
            System.out.println(borrow);
        }
        System.out.println("===================================");

        sqlSession.close();
    }

    //统计在借书籍
    @Test
    public void getBorrowNumbersTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
        int borrowCount = mapper.getBorrowCount(3);

        System.out.println("================================");
        System.out.println("在姐图书（本）：" + borrowCount);
        System.out.println("================================");

        sqlSession.close();
    }

    //可借阅数量（10本）此处不实现，在业务层实现调用在借图书用10减去得结果

    //增加借阅记录
    @Test
    public void addBorrowTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
        Borrow borrow = new Borrow(4, 4, 3, new Date(), null, 3, new Date(), null, null);

        int row = mapper.addBorrow(borrow);
        if (row > 0) {
            System.out.println("===============================");
            System.out.println("insert success!!");
            System.out.println("===============================");
        }else {
            System.out.println("===============================");
            System.out.println("insert fail!!");
            System.out.println("===============================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //通过id删除借阅记录
    @Test
    public void deleteBorrowByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
        int row = mapper.deleteBorrowById(4);

        if (row > 0) {
            System.out.println("===============================");
            System.out.println("delete success!!");
            System.out.println("===============================");
        }else {
            System.out.println("===============================");
            System.out.println("delete fail!!");
            System.out.println("===============================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //修改借阅记录
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BorrowMapper mapper = sqlSession.getMapper(BorrowMapper.class);
        Borrow borrow = new Borrow(4, null, null, null, null, null, null, 1, new Date());

        int row = mapper.modify(borrow);
        if (row > 0) {
            System.out.println("===============================");
            System.out.println("modify success!!");
            System.out.println("===============================");
        }else {
            System.out.println("===============================");
            System.out.println("modify fail!!");
            System.out.println("===============================");
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
