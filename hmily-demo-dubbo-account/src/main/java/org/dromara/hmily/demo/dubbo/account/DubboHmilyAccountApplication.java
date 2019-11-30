

package org.dromara.hmily.demo.dubbo.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The DubboHmilyAccountApplication.
 *
 * @author xiaoyu
 */
@SpringBootApplication
@MapperScan("org.dromara.hmily.demo.dubbo.account.mapper")
public class DubboHmilyAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboHmilyAccountApplication.class, args);
        System.err.println("\n" +
                "============================╆━━━━━━━━━━╅============================\n" +
                "  <<<<<=====<<<<<======<<<<<┃DubboHmilyAccountApplication服务端启动成功!┃>>>>>======>>>>>=====>>>>>\n" +
                "============================╄━━━━━━━━━━╃============================");
    }


}
