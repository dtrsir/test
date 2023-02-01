package dao.bill;

import org.apache.ibatis.annotations.Param;
import pojo.Bill;

import java.util.List;

public interface BillMapper {
    //根据供应商Id查询订单数量
    public int getBillCountByProviderId(@Param("providerId") Integer providerId);

    //增加订单
    public int add(Bill bill);

    //通过查询条件获取供应商列表-getBillList
    public List<Bill> getBillList(@Param("productName") String productName,
                                  @Param("providerId") String providerId,
                                  @Param("isPayment") String isPayment,
                                  @Param("from") Integer from,
                                  @Param("pageSize") Integer pageSize);

    //通过条件查询，查询供货商数量
    public int getBillCount(@Param("productName") String productName,
                            @Param("providerId") String providerId,
                            @Param("isPayment") String isPayment);

    //通过delId删除Bill
    public int deleteBillById(@Param("id") Integer id);

    //通过billId获取Bill
    public Bill getBillById(@Param("id") Integer id);

    //修改订单信息
    public int modify(Bill bill);

    //根据供应商Id删除订单信息
    public int deleteBillByProviderId(@Param("providerId") Integer providerId);
}
