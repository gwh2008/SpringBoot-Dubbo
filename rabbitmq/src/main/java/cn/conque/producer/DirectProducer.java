package cn.conque.producer;

import cn.conque.bean.Message;
import cn.conque.config.RabbitmqDirectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  路由模式:direct
 */
@Component
public class DirectProducer {
    private static final Logger logger = LoggerFactory.getLogger(DirectProducer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void directSendMessage(Message message, String routingKey) {
        logger.info("[===========> DirectExchange Send Message] body: " + message.toString());
        amqpTemplate.convertAndSend(RabbitmqDirectConfig.DIRECT_EXCHANGE, routingKey, message);
    }
}
