package cn.conque;

import cn.conque.bean.Message;
import cn.conque.producer.DirectProducer;
import cn.conque.producer.FanoutProducer;
import cn.conque.producer.TopicProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private FanoutProducer fanoutProducer;

	@Test
	public void testFanoutExchange() {
        Message message = new Message();
        message.setTitle("标题：发布订阅FanoutExchange");
        message.setContent("内容：发布订阅FanoutExchange");
        fanoutProducer.fanoutSendMessage(message);
	}

	@Autowired
    private TopicProducer topicProducer;

    @Test
    public void testTopicExchange001() {
        // 消费者A B Other都能收到
        String routingKey = "topic.a";
        Message message = new Message();
        message.setTitle("标题：主题模式topicExchange");
        message.setContent("内容：主题模式send message to topicExchange");
        topicProducer.topicSendMessage(message, routingKey);
    }

    @Test
    public void testTopicExchange002() {
        // 消费者B Other都能收到
        String routingKey = "topic.word001";
        Message message = new Message();
        message.setTitle("topicExchange");
        message.setContent("send message to topicExchange");
        topicProducer.topicSendMessage(message, routingKey);
    }

    @Test
    public void testTopicExchange003() {
        // 消费者Other能收到
        String routingKey = "topic.word001.word002";
        Message message = new Message();
        message.setTitle("topicExchange");
        message.setContent("send message to topicExchange");
        topicProducer.topicSendMessage(message, routingKey);
    }

    @Autowired
    private DirectProducer directProducer;

    @Test
    public void testDirectExchange001() {
        // 消费者A能收到
        String routingKey = "direct.a";
        Message message = new Message();
        message.setTitle("标题：路由模式 directExchange");
        message.setContent("内容：路由模式 send message to directExchange");
        directProducer.directSendMessage(message, routingKey);
    }

    @Test
    public void testDirectExchange002() {
        // 谁都收不到
        String routingKey = "direct.b";
        Message message = new Message();
        message.setTitle("directExchange");
        message.setContent("send message to directExchange");
        directProducer.directSendMessage(message, routingKey);
    }
}
