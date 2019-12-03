package cn.conque.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布订阅模式
 */
@Configuration
public class RabbitmqFanoutConfig {

    public static final String FANOUT_QUEUE_A = "fanout_queue_a";
    public static final String FANOUT_QUEUE_B = "fanout_queue_b";
    public static final String FANOUT_QUEUE_C = "fanout_queue_c";

    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(FANOUT_QUEUE_A);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(FANOUT_QUEUE_B);
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue(FANOUT_QUEUE_C);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding queueABindingExchange(Queue fanoutQueueA, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding queueBBindingExchange(Queue fanoutQueueB, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    public Binding queueCBindingExchange(Queue fanoutQueueC, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }
}
