package com.keeplearning135.feign.service.hystrix;

import com.keeplearning135.feign.service.FeignService;
import org.springframework.stereotype.Component;


@Component
public class FeignServiceHystrix implements FeignService {

    @Override
    public String queryUserInfo(String userId) {
        return "queryUserInfo by userId：" + userId + " err！from feign hystrix";
    }
    
}
