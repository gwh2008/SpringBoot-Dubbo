package cn.conque.producer;

import cn.conque.bean.Message;
import cn.conque.config.RabbitmqTopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 主题模式:topic
 */
@Component
public class TopicProducer {
    private static final Logger logger = LoggerFactory.getLogger(TopicProducer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void topicSendMessage(Message message, String routingKey) {
        logger.info("[===========> TopicExchange Send Message] body: " + message.toString());
        amqpTemplate.convertAndSend(RabbitmqTopicConfig.TOPIC_EXCHANGE, routingKey, message);
    }
}
