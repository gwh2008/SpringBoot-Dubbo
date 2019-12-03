package cn.conque.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 路由模式
 */
@Component
public class RabbitmqDirectConfig {
    public static final String DIRECT_QUEUE_A = "direct_queue_a";
    public static final String DIRECT_QUEUE_B = "direct_queue_b";

    public static final String DIRECT_EXCHANGE = "direct_exchange";

    public static final String DIRECT_ROUTING_KEY_A = "direct.a";
    public static final String DIRECT_ROUTING_KEY_B = "direct.#";

    @Bean
    public Queue directQueueA() {
        return new Queue(DIRECT_QUEUE_A);
    }

    @Bean
    public Queue directQueueB() {
        return new Queue(DIRECT_QUEUE_B);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding directBinding001(Queue directQueueA, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueA).to(directExchange).with(DIRECT_ROUTING_KEY_A);
    }

    @Bean
    public Binding directBinding002(Queue directQueueB, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueueB).to(directExchange).with(DIRECT_ROUTING_KEY_B);
    }
}
