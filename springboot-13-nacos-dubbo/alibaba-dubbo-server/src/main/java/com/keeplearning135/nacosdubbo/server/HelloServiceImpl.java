package com.keeplearning135.nacosdubbo.server;

import com.keeplearning135.nacosdubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

// org.apache.dubbo.config.annotation.Service
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "hello " + name;
    }

}