import com.zhong.dao.bill.BillMapper;
import com.zhong.pojo.Bill;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BillMapperTest {

    //根据供应商Id查询订单数量
    @Test
    public void getBillCountByProviderIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        //模拟前端传递的参数
        Integer providerId = new Integer(1);

        int billCount = mapper.getBillCountByProviderId(providerId);

        //模拟前端测试
        System.out.println("===============================");
        System.out.println(providerId + "号供应商的订单数量：" + billCount);
        System.out.println("==============================");

        sqlSession.close();
    }

    //添加订单
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Date time = new Date();
        BigDecimal productCount = new BigDecimal(2000.00);
        BigDecimal totalPrice = new BigDecimal(4000.00);
        int row = mapper.add(new Bill(19, "BILL2022_019", "可口可乐", "饮料", "瓶", productCount, totalPrice, 2, 1, 1, time, null, null, "北京三木堂商贸有限公司"));
        if (row > 0) {
            System.out.println("success!!");
        }else {
            System.out.println("false");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    //通过查询条件获取供应商列表
    @Test
    public void getBillListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> billList = mapper.getBillList(null,"1",null,null,2);
        for (Bill bill : billList) {
            System.out.println(bill);
        }

        sqlSession.close();
    }

    //通过条件查询，查询供货商数量
    @Test
    public void getBillCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int billCount = mapper.getBillCount(null, null, "2");

        System.out.println("==================================");
        System.out.println("根据查询条件查到的订单数为"+billCount);
        System.out.println("==================================");

        sqlSession.close();
    }

    //通过delId删除Bill
    @Test
    public void deleteBillByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = mapper.deleteBillById(19);
        if (i > 0) {
            System.out.println("==========================");
            System.out.println("success!!");
            System.out.println("==========================");
        }else {
            System.out.println("==========================");
            System.out.println("false!!");
            System.out.println("==========================");
        }
        sqlSession.commit();

        sqlSession.close();
    }

    //通过billId获取Bill
    @Test
    public void getBillByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = mapper.getBillById(18);
        System.out.println(bill);

        sqlSession.close();
    }

    //修改订单信息
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        BigDecimal productCount = new BigDecimal(2020.00);
        BigDecimal totalPrice = new BigDecimal(4020.00);
        Date time = new Date();
        int row = mapper.modify(new Bill(19, "BILL2022_019", "可口可乐", "饮料", "瓶", productCount, totalPrice, 2, 1, null, null, 1, time, "北京三木堂商贸有限公司222"));

        if (row > 0) {
            System.out.println("==========================");
            System.out.println("success!!");
            System.out.println("==========================");
        }else {
            System.out.println("==========================");
            System.out.println("false!!");
            System.out.println("==========================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //根据供应商Id删除订单信息
    @Test
    public void deleteBillByProviderIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int row = mapper.deleteBillByProviderId(1);

        if (row > 0) {
            System.out.println("==========================");
            System.out.println("success!!");
            System.out.println("==========================");
        }else {
            System.out.println("==========================");
            System.out.println("false!!");
            System.out.println("==========================");
        }
//        sqlSession.commit();
        sqlSession.close();
    }


}
