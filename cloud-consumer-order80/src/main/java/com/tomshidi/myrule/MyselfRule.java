package com.tomshidi.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author TomShiDi
 * @Since 2020/7/3
 * @Version 1.0
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new MyBoundRule();
    }
}
