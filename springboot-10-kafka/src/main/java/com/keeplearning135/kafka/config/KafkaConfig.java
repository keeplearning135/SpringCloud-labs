package com.keeplearning135.kafka.config;

import com.keeplearning135.kafka.constant.Topic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic groupTopic() {
        // Specify the topic name, number of partitions, and replication factor.
        return new NewTopic(Topic.GROUP, 10, (short) 2);
    }

}
