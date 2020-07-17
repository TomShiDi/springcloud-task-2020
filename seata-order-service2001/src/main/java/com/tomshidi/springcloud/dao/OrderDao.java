package com.tomshidi.springcloud.dao;

import com.tomshidi.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param order 订单信息
     * @return 数据库记录编号
     */
    long create(Order order);

    /**
     * 修改订单状态 0为创建中,1为创建完毕
     * @param id 订单编号
     * @param status 状态值0或者1
     */
    void updateOrderStatus(@Param("id") Long id, @Param("status") Integer status);
}
