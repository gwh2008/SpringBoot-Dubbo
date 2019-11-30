
package org.dromara.hmily.demo.dubbo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboTccOrderApplication.
 *
 * 订单服务启动类
 */
@SpringBootApplication
@MapperScan("org.dromara.hmily.demo.dubbo.order.mapper")
public class DubboHmilyOrderApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(DubboHmilyOrderApplication.class, args);
    }


}
