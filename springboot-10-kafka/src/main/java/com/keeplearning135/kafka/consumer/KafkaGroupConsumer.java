package com.keeplearning135.kafka.consumer;

import com.keeplearning135.kafka.constant.Topic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaGroupConsumer {

    @KafkaListener(id = "consumer1-1", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"0", "1"})
            })
    public void consumer1_1(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-1 received message:" + record.value());
    }

    @KafkaListener(id = "consumer1-2", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"2", "3"})
            })
    public void consumer1_2(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-2 received message:" + record.value());
    }

    @KafkaListener(id = "consumer1-3", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"0", "1"})
            })
    public void consumer1_3(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-3 received message:" + record.value());
    }

    @KafkaListener(id = "consumer2-1", groupId = "group2", topics = Topic.GROUP)
    public void consumer2_1(ConsumerRecord<String, Object> record) {
        System.err.println("consumer2-1 received message:" + record.value());
    }
}
