package com.keeplearning135.kafka.consumer;

import com.keeplearning135.kafka.constant.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaSimpleConsumer {

    @KafkaListener(groupId = "simpleGroup", topics = Topic.SIMPLE)
    public void consumer1_1(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer) {
        System.out.println("Consumer received message:" + record.value() + "; topic:" + topic);

        /*
         * consumer.commitSync(); If manual submission is required asynchronously, perform manual asynchronous submission.
         * consumer.commitAsync(); If manual synchronous submission is required, perform manual synchronous submission.
         */
    }
}
