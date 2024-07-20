package com.keeplearning135.kafka.consumer;

import com.alibaba.fastjson.JSON;
import com.keeplearning135.kafka.bean.Programmer;
import com.keeplearning135.kafka.constant.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaBeanConsumer {

    @KafkaListener(groupId = "beanGroup",topics = Topic.BEAN)
    public void consumer(ConsumerRecord<String, Object> record) {
        System.out.println("Consumer received message:" + JSON.parseObject(record.value().toString(), Programmer.class));
    }
}
