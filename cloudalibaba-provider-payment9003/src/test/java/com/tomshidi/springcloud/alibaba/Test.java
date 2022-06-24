package com.tomshidi.springcloud.alibaba;

import cn.hutool.core.util.IdUtil;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author TomShiDi
 * @Since 2020/7/15
 * @Version 1.0
 */
@SpringBootTest
public class Test {
    @org.junit.Test
    public void getRandomString() {
        System.out.println(IdUtil.simpleUUID());
    }
}
