package com.tomshidi.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author TomShiDi
 * @Since 2020/7/17
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "com.tomshidi.springcloud.dao")
public class MybatisConfig {
}
