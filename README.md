# springcloud-task-2020 练习源码
[![Wiki](https://badgen.net/badge/icon/wiki?icon=wiki&label)](https://github.com/TomShiDi/springcloud-task-2020/wiki)
[![Java CI with Maven](https://github.com/TomShiDi/springcloud-task-2020/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/TomShiDi/springcloud-task-2020/actions/workflows/maven.yml)
[![codecov](https://codecov.io/gh/TomShiDi/springcloud-task-2020/branch/master/graph/badge.svg?token=B7JPXI8L4O)](https://codecov.io/gh/TomShiDi/springcloud-task-2020)
[![Contributors](https://img.shields.io/github/contributors/TomShiDi/springcloud-task-2020)](https://github.com/TomShiDi/springcloud-task-2020/graphs/contributors)


This is a source code for springcloud studying

## 各模块功能以及所用技术总结

***********
+ 模块cloud-api-common
```java
//使用maven的项目聚合分离功能，将通用的类单独拿出来
//将公共依赖分离出来
```
******************
+ 模块cloud-config-center3344
```java
//注册中心服务端，实现从git上拉取配置信息
//用到的技术: springcloud-config-center-server、RabbitMQ消息总线、eureka服务注册发现中心
```
**************
+ 模块cloud-config-client3355、3366
```java
//模拟从springcloud center配置中心拉取配置
//使用到的技术: spring-cloud-starter-config、RabbitMQ消息总线、eureka服务注册发现中心
```
******************
+ 模块cloud-consumer-feign-hystrix-order80
```java
//服务调用者，演示hystrix的服务降级和熔断
//使用的技术: openfeign、hystrix、eureka
```
**************
+ 模块cloud-consumer-feign-order80
```java
//服务调用者，演示openfeign的使用以及ribbon的负载均衡算法
//使用的技术: openfeign、eureka、ribbon
```
***************
+ 模块cloud-consumer-hystrix-dashboard9001
```java
//hystrix信息展示面板，查看服务降级和熔断信息
//使用的技术: hystrix-dashboard、hystrix、eureka
```
**********
+ 模块cloud-consumer-order80
```java
//服务调用者，测试eureka服务注册发现功能，测试zipkin的链路监控功能
//使用的技术: eureka、zipkin
```
+ 模块cloud-consumerconsul-order80
```java
//服务调用者，使用consul作为服务注册中心
//使用的技术: consul-discovery
```
***************
+ 模块cloud-consumerzk-order80
```java
//服务调用者，使用zookeeper作为服务注册中心
//使用的技术: zookeeper-discovery
```
**************
+ 模块cloud-eureka-server7001、7002
```java
//eureka服务注册中心，演示集群实现
//使用的技术: eureka
```
***************
+ 模块cloud-gateway-gateway9527
```java
//网关效果演示
//使用的技术: gateway、eureka
```
***************
+ 模块cloud-provider-hystrix-payment8001
```java
//服务提供者。使用hystrix做服务熔断和降级
//使用的技术: hystrix、eureka
```
*****************
+ 模块cloud-provider-payment8001、8002
```java
//服务提供者，演示eureka服务注册和zipkin链路监控
//使用的技术: eureka、zipkin、mybatis、Druid
```
******************
+ 模块cloud-provider-payment8004
```java
//服务提供者，使用zookeeper做服务注册中心
//使用的技术: zookeeper-discovery
```
***************
+ 模块cloud-providerconsul-payment8006
```java
//服务提供者，使用consul作为服务注册中心
//使用的技术: consul-discovery
```
***************
+ 模块cloud-stream-rabbitmq-consumer8802、8803
```java
//rabbit消息消费者，使用stream统一管理消息中间件
//使用的技术: eureka、stream-rabbit
```
***********
+ 模块cloud-stream-rabbitmq-provider8801
```java
//rabbit消息提供者，使用stream统一管理消息中间件
//使用的技术: eureka、stream-rabbit
```
***************
+ 模块cloudalibaba-config-nacos-client3377
```java
//nacos配置中心使用实例
//使用的技术: nacos-config、nacos-discovery
```
**************
+ 模块cloudalibaba-consumer-nacos-order83、84
```java
//服务调用者,使用nacos做服务注册中心
//使用的技术: nacos-discovery
```
**************
+ 模块cloudalibaba-provider-payment9001、9002
```java
//服务提供者，使用nacos做服务注册中心
//使用的技术: nacos-discovery
```
**********
+ 模块cloudalibaba-provider-payment9003、9004
```java
//服务提供者，使用nacos作为服务注册中心，使用sentinel做服务限流和熔断
//使用的技术: nacos-discovery、sentinel
```
***************
+ 模块cloudalibaba-sentinel-service8401
```java
//sentinel各个参数使用实例，nacos配置持久化
//使用的技术: nacos-discovery、datasource-nacos、sentinel、openfeign
```
**************
+ 模块seata-account-service2003、seata-storage-service2002、seata-order-service2001
```java
//分布式事务实现
//使用的技术: nacos-discovery、seata、openfeign、mybatis、mysql-connector
```

























