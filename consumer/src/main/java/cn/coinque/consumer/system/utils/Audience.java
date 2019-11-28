package cn.coinque.consumer.system.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/10/2.
 */
@Component
@ConfigurationProperties(prefix = "audience")
@Data
public class Audience {
    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}
