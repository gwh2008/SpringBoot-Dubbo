package cn.coinque.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author
 */
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
        System.err.println("\n" +
                "============================╆━━━━━━━━━━╅============================\n" +
                "  <<<<<=====<<<<<======<<<<<┃ Web 服务端启动成功!┃>>>>>======>>>>>=====>>>>>\n" +
                "============================╄━━━━━━━━━━╃============================");
    }
}
