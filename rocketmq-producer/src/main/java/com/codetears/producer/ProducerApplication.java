package com.codetears.producer;

import com.codetears.producer.domain.OrderPaidEvent;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2019/12/18 下午4:06
 */
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Resource
    private DefaultMQProducer defaultMQProducer;

    @Resource
    private RocketMQTemplate rocketMqTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // send string
        rocketMqTemplate.convertAndSend("string-topic", "Hello, World!");

        // send string with spring Message
        rocketMqTemplate.send("string-topic", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());

        // send user-defined object
        rocketMqTemplate.convertAndSend("order-paid-topic", new OrderPaidEvent("T_001", new BigDecimal("88.00")));

        // send message with special tag
        rocketMqTemplate.convertAndSend("message-ext-topic:tag0", "I'm from tag0");
        rocketMqTemplate.convertAndSend("message-ext-topic:tag1", "I'm from tag1");
    }

}