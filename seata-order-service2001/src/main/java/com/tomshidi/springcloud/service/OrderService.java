package com.tomshidi.springcloud.service;

import com.tomshidi.springcloud.domain.Order;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
public interface OrderService {
    void create(Order order);

    void updateOrderStatus(Long id, Integer status);
}
