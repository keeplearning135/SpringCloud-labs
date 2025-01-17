package com.keeplearning135.nacosdubbo.client;

import com.keeplearning135.nacosdubbo.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@SpringBootApplication
public class DubboClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {

        @Reference
        HelloService helloService;

        @GetMapping("/test")
        public String test() {
            return helloService.hello("keelearning135");
        }
    }

}