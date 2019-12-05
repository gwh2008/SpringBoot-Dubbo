package cn.conque.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动类
 *
 */
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        System.err.println("\n" +
                "============================╆━━━━━━━━━━━━╅============================\n" +
                "  <<<<<=====<<<<<======<<<<<┃ ApiGateway 服务端启动成功!┃>>>>>======>>>>>=====>>>>>\n" +
                "============================╄━━━━━━━━━━━━╃============================");
    }
}
