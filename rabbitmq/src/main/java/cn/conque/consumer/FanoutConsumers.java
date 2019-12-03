package cn.conque.consumer;

import cn.conque.bean.Message;
import cn.conque.config.RabbitmqFanoutConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅
 */
@Component
public class FanoutConsumers {
    private static final Logger logger = LoggerFactory.getLogger(FanoutConsumers.class);

    @RabbitListener(queues = RabbitmqFanoutConfig.FANOUT_QUEUE_A)
    public void fanoutQueueA(Message message) {
        logger.info("[===========> Message From FanoutQueueA] body: " + message.toString());
    }

    @RabbitListener(queues = RabbitmqFanoutConfig.FANOUT_QUEUE_B)
    public void fanoutQueueB(Message message) {
        logger.info("[===========> Message From FanoutQueueB] body: " + message.toString());
    }

    @RabbitListener(queues = RabbitmqFanoutConfig.FANOUT_QUEUE_C)
    public void fanoutQueueC(Message message) {
        logger.info("[===========> Message From FanoutQueueC] body: " + message.toString());
    }
}
