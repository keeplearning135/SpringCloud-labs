package com.keeplearning135.provider.impl;

import com.keeplearning135.service.ProviderService;
import org.apache.dubbo.config.annotation.Service;

@Service(weight = 4)
public class ProviderServiceImpl implements ProviderService {

    @Override
    public String showMsg(String msg) {
        //System.out.println("调用测试duboo负载均衡服务1");
        //System.out.println("调用测试duboo负载均衡服务2");
        System.out.println("调用测试duboo负载均衡服务3");
        return "hello springboot duboo! "+msg;
    }
}