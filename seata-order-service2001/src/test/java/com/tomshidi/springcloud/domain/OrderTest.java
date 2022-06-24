package com.tomshidi.springcloud.domain;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author TomShiDi
 * @date 2022/6/24 16:30
 */
public class OrderTest {

    @Test
    public void doTest() {
        Order order = new Order();
        order.setId(1L);
        order.setCount(2);
        order.setMoney(BigDecimal.valueOf(3.0));
        order.setProductId(4L);
        order.setUserId(5L);
        Assert.assertNotNull(order);
    }
}