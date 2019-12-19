package com.codetears.consumer.consumers;

import com.codetears.consumer.domain.OrderPaidEvent;
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
@RocketMQMessageListener(topic = "order-paid-topic", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("------- OrderPaidEventConsumer received: {}", orderPaidEvent);
    }
}
