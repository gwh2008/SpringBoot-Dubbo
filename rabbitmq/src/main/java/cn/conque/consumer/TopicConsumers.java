package cn.conque.consumer;

import cn.conque.bean.Message;
import cn.conque.config.RabbitmqTopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 主题模式
 */
@Component
public class TopicConsumers {
    private static final Logger logger = LoggerFactory.getLogger(TopicConsumers.class);

    @RabbitListener(queues = RabbitmqTopicConfig.TOPIC_QUEUE_A)
    public void topicQueueA(Message message) {
        logger.info("[===========> Message From TopicQueueA] body: " + message.toString());
    }

    @RabbitListener(queues = RabbitmqTopicConfig.TOPIC_QUEUE_B)
    public void topicQueueB(Message message) {
        logger.info("[===========> Message From TopicQueueB] body: " + message.toString());
    }

    @RabbitListener(queues = RabbitmqTopicConfig.TOPIC_QUEUE_OTHER)
    public void topicQueueOther(Message message) {
        logger.info("[===========> Message From TopicQueueOther] body: " + message.toString());
    }
}
