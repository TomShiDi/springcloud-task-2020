package com.tomshidi.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author TomShiDi
 * @Since 2020/7/3
 * @Version 1.0
 */
public class MyBoundRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerIndexCounter;

    private static Logger logger = LoggerFactory.getLogger(MyBoundRule.class);

    public MyBoundRule() {
        this.nextServerIndexCounter = new AtomicInteger(0);
    }

    public MyBoundRule(ILoadBalancer iLoadBalancer) {
        this();
        setLoadBalancer(iLoadBalancer);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer iLoadBalancer = null;
        if ((iLoadBalancer = super.getLoadBalancer()) == null) {
            logger.warn("no load balancer");
            return null;
        }
        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> upServers = iLoadBalancer.getReachableServers();
            List<Server> allServers = iLoadBalancer.getAllServers();
            int upCount = upServers.size();
            int allCount = allServers.size();
            if ((upCount == 0) || (allCount == 0)) {
                logger.warn("there is no up server from load balancer : {}", iLoadBalancer);
            }

            int next = increaseAndGetIndex(allCount);
            server = allServers.get(next);

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive() && server.isReadyToServe()) {
                return server;
            }

            server = null;
        }

        if (count >= 10) {
            logger.warn("no available alive servers from load balancer : {}", iLoadBalancer);
        }

        return server;
    }

    private int increaseAndGetIndex(int modulo) {
        while (true) {
            int current = nextServerIndexCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerIndexCounter.compareAndSet(current, next)) {
                return next;
            }
        }
    }
}
