package cn.conque.api.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户表实体
 * @author
 */
@Data
public class User implements Serializable {
    Long id;
    String name;
    Integer age;
    Date ctm;

}
