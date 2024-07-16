package com.keeplearning135.consumer.controller;

import com.keeplearning135.consumer.service.ConsumerService;
import com.keeplearning135.consumer.service.impl.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caohaiyang
 * @create 2021-05-10 下午 04:17
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerServiceImpl consumerServiceImpl;

    @RequestMapping("/getMsg/{msg}")
    public String getMsg(@PathVariable String msg){
        return this.consumerServiceImpl.showMsg(msg);
    }
}