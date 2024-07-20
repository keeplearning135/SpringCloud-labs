package com.keeplearning135.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.keeplearning135.kafka.Producer.KafKaCustomrProducer;
import com.keeplearning135.kafka.bean.Programmer;
import com.keeplearning135.kafka.constant.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Slf4j
@RestController
public class SendMsgController {

    @Autowired
    private KafKaCustomrProducer producer;
    @Autowired
    private KafkaTemplate kafkaTemplate;


    @GetMapping("sendSimple")
    public void sendSimple() {
        producer.sendMessage(Topic.SIMPLE, "hello spring boot kafka");
    }

    @GetMapping("sendBean")
    public void sendBean() {
        Programmer programmer = new Programmer("xiaoming", 12, 21212.33f, new Date());
        producer.sendMessage(Topic.BEAN, JSON.toJSON(programmer).toString());
    }



    @GetMapping("sendGroup")
    public void sendGroup() {
        for (int i = 0; i < 4; i++) {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(Topic.GROUP, i % 4, "key", "hello group " + i);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.info("Send Message failure:" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> sendResult) {
                    System.out.println("Send Result:" + sendResult.toString());
                }
            });
        }
    }
}
