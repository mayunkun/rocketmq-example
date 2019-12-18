package com.codetears.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2019/12/18 下午3:47
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "string-topic", consumerGroup = "string_consumer")
public class StringConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("------- StringConsumer received: {}", message);
    }
}
