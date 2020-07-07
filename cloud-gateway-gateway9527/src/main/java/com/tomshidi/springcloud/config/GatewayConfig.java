package com.tomshidi.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author TomShiDi
 * @Since 2020/7/7
 * @Version 1.0
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_tomshidi",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")
        );
        return routes.build();
    }
}
