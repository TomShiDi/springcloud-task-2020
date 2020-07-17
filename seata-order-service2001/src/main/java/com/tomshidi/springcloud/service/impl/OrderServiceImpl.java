package com.tomshidi.springcloud.service.impl;

import com.tomshidi.springcloud.dao.OrderDao;
import com.tomshidi.springcloud.domain.Order;
import com.tomshidi.springcloud.enums.OrderEnum;
import com.tomshidi.springcloud.service.AccountService;
import com.tomshidi.springcloud.service.OrderService;
import com.tomshidi.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

//    @Resource
    private StorageService storageService;

//    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        log.info("------->开始新建订单");
        long id = orderDao.create(order);
        log.info("------->订单创建结束");

        log.info("-------> 订单微服务开始调用库存，做扣减 开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------> 订单微服务开始调用库存，做扣减 结束");

        log.info("-------> 订单微服务调用账户，减余额 开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------> 订单微服务调用账户，减余额 结束");

        log.info("-------> 修改订单状态开始");
        orderDao.updateOrderStatus(id, OrderEnum.ORDER_CREATING.getCode());
        log.info("-------> 修改订单状态结束");
    }

    @Override
    public void updateOrderStatus(Long id, Integer status) {

    }
}
