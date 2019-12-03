package cn.conque.producer;

import cn.conque.bean.Message;
import cn.conque.config.RabbitmqFanoutConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * 交换机,有类型,发布订阅:fanout
 *
 */
@Component
public class FanoutProducer {
    private static final Logger logger = LoggerFactory.getLogger(FanoutProducer.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void fanoutSendMessage(Message message) {
        logger.info("[===========> FanoutExchange Send Message] body: " + message.toString());
        amqpTemplate.convertAndSend(RabbitmqFanoutConfig.FANOUT_EXCHANGE, "", message);
    }
}
