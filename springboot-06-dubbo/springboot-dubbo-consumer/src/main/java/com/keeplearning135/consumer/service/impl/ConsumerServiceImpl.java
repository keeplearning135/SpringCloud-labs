package com.keeplearning135.consumer.service.impl;

import com.keeplearning135.service.ProviderService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * 消费服务业务层
 * 注意: 这里@Service 导入的是springframework的包而不是Dubbo
 * 区别:
 *     服务提供者(provider): @Service使用的是dubbo包下的
 *     服务消费者(consumer): @Service使用的是springframework包下的
 * @author caohaiyang
 * @create 2021-05-10 下午 04:10
 */
@Service
public class ConsumerServiceImpl implements ProviderService {

    /**
     * 使用的是dubbo包下的@Reference
     *      dubbo服务级别
     *         1. 权重随机算法的 RandomLoadBalance、
     *         2. 基于最少活跃调用数算法的 LeastActiveLoadBalance、
     *         3. 基于 hash 一致性的 ConsistentHashLoadBalance，
     *         4. 以及基于加权轮询算法的 RoundRobinLoadBalance。
     * 对应负载均衡策略参数: random,leastactive,consistenthash,roundrobin
     */
    @Reference(loadbalance = "roundrobin")
    private ProviderService providerService;

    @Override
    public String showMsg(String msg) {
        return this.providerService.showMsg(msg);
    }

}