package com.keeplearning135.kafka.Producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafKaCustomrProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, Object object) {

        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, object);

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


