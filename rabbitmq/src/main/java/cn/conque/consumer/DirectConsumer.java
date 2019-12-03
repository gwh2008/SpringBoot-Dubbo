package cn.conque.consumer;


import cn.conque.config.RabbitmqDirectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import cn.conque.bean.Message;

/**
 * 路由模式
 */
@Component
public class DirectConsumer {
    private static final Logger logger = LoggerFactory.getLogger(DirectConsumer.class);

    @RabbitListener(queues = RabbitmqDirectConfig.DIRECT_QUEUE_A)
    public void directQueueA(Message message) {
        logger.info("[===========> Message From DirectQueueA] body: " + message.toString());
    }

    @RabbitListener(queues = RabbitmqDirectConfig.DIRECT_QUEUE_B)
    public void directQueueB(Message message) {
        logger.info("[===========> Message From DirectQueueB] body: " + message.toString());
    }
}
