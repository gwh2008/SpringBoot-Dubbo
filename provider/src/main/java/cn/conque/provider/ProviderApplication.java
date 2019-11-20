package cn.conque.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动类
 *
 */
@SpringBootApplication
@MapperScan("cn.conque.provider.dao")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
        System.err.println("\n" +
                "============================╆━━━━━━━━━━━━╅============================\n" +
                "  <<<<<=====<<<<<======<<<<<┃ Service 服务端启动成功!┃>>>>>======>>>>>=====>>>>>\n" +
                "============================╄━━━━━━━━━━━━╃============================");
    }
}
