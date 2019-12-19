package com.codetears.producer;

import com.codetears.producer.domain.OrderPaidEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
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
@Slf4j
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMqTemplate;

    @Resource
    private DefaultMQProducer defaultMQProducer;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        // send string
//        rocketMqTemplate.convertAndSend("string-topic", "Hello, World!");
//
//        // send string with spring Message
//        rocketMqTemplate.send("string-topic", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
//
//        // send user-defined object
//        rocketMqTemplate.convertAndSend("order-paid-topic", new OrderPaidEvent("T_001", new BigDecimal("88.00")));
//
//        // send message with special tag
//        rocketMqTemplate.convertAndSend("message-ext-topic:tag0", "I'm from tag0");
//        rocketMqTemplate.convertAndSend("message-ext-topic:tag1", "I'm from tag1");
//
//        // delay message
//        Message message = new Message("string-topic", "this is a delay message".getBytes("UTF-8"));
//        message.setDelayTimeLevel(3);
//        defaultMQProducer.send(message);

        // transaction message
        org.springframework.messaging.Message transactionMessage = MessageBuilder.withPayload("this is a transaction message").build();
        TransactionSendResult sendResult = rocketMqTemplate.sendMessageInTransaction("rocket", "ts", transactionMessage, null);
        log.info("消息发送响应信息："+sendResult.toString());
    }

}