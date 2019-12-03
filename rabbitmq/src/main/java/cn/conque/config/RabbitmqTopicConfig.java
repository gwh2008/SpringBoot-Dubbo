package cn.conque.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 主题模式
 */
@Configuration
public class RabbitmqTopicConfig {

    public static final String TOPIC_QUEUE_A = "topic.a";
    public static final String TOPIC_QUEUE_B = "topic.b";
    public static final String TOPIC_QUEUE_OTHER = "topic.other";

    public static final String TOPIC_ROUTING_KEY_A = "topic.a";
    public static final String TOPIC_ROUTING_KEY_B = "topic.*";
    public static final String TOPIC_ROUTING_KEY_C = "topic.#";

    public static final String TOPIC_EXCHANGE = "topic_exchange";

    @Bean
    public Queue topicQueueA() {
        return new Queue(TOPIC_QUEUE_A);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(TOPIC_QUEUE_B);
    }

    @Bean
    public Queue topicQueueOther() {
        return new Queue(TOPIC_QUEUE_OTHER);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicQueueABindingTopicExchange(Queue topicQueueA, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with(TOPIC_ROUTING_KEY_A);
    }

    @Bean
    public Binding topicQueueBBindingTopicExchange(Queue topicQueueB, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with(TOPIC_ROUTING_KEY_B);
    }

    @Bean
    public Binding topicQueueCBindingTopicExchange(Queue topicQueueOther, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueOther).to(topicExchange).with(TOPIC_ROUTING_KEY_C);
    }
}
