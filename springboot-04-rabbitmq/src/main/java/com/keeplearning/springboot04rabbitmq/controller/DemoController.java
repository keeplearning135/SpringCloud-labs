package com.keeplearning.springboot04rabbitmq.controller;

import com.keeplearning.springboot04rabbitmq.model.User;
import com.keeplearning.springboot04rabbitmq.rabbit.fanout.FanoutSender;
import com.keeplearning.springboot04rabbitmq.rabbit.hello.HelloSender;
import com.keeplearning.springboot04rabbitmq.rabbit.many.NeoSender;
import com.keeplearning.springboot04rabbitmq.rabbit.many.NeoSender2;
import com.keeplearning.springboot04rabbitmq.rabbit.object.ObjectSender;
import com.keeplearning.springboot04rabbitmq.rabbit.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/")
public class DemoController {

    @Autowired
    private FanoutSender sender;


    /////-----------------
    @GetMapping("fanoutSender")
    public void fanoutSender() throws Exception {
        sender.send();
    }

    /////-----------------
    @Autowired
    private HelloSender helloSender;
    @GetMapping("hello")
    public void hello() throws Exception {
        helloSender.send();
    }


    /////-----------------
    @Autowired
    private NeoSender neoSender;
    @GetMapping("oneToMany")
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
    }

    /////-----------------
    @Autowired
    private NeoSender2 neoSender2;
    @GetMapping("manyToMany")
    public void manyToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
            neoSender2.send(i);
        }
    }

    /////-----------------
    @Autowired
    private ObjectSender objectSender;
    @GetMapping("sendOject")
    public void sendOject() throws Exception {
        var user=new User();
        user.setName("neo");
        user.setPass("123456");
        objectSender.send(user);
    }


    /////-----------------
    @Autowired
    private TopicSender topicSender;

    @GetMapping("topic")
    public void topic() throws Exception {
        topicSender.send();
    }

    @GetMapping("topic1")
    public void topic1() throws Exception {
        topicSender.send1();
    }

    @GetMapping("topic2")
    public void topic2() throws Exception {
        topicSender.send2();
    }
}