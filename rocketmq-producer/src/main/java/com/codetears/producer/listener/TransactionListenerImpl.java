package com.codetears.producer.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @author l'amour solitaire
 * @description TODO
 * @date 2019/12/19 上午9:37
 */
@Slf4j
@RocketMQTransactionListener(txProducerGroup = "rocket")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("本地事务和消息发送:" + JSON.toJSONString(message));

        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        log.info("回查信息:" + JSON.toJSONString(message));
        return RocketMQLocalTransactionState.COMMIT;
    }
}
