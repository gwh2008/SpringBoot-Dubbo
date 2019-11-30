

package cn.conque.hmily.demo.dubbo.account.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class AccountDO implements Serializable {

    private static final long serialVersionUID = -81849676368907419L;

    private Integer id;

    private String userId;

    private BigDecimal balance;

    private BigDecimal freezeAmount;

    private Date createTime;

    private Date updateTime;


}
