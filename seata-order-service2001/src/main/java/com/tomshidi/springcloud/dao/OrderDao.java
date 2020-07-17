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
     */
    void create(Order order);

    /**
     * 修改订单状态 0为创建中,1为创建完毕
     * @param userId 用户编号
     * @param status 状态值0或者1
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
