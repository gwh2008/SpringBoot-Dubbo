

package cn.conque.hmily.demo.dubbo.account.api.service;

import org.dromara.hmily.annotation.Hmily;
import cn.conque.hmily.demo.dubbo.account.api.dto.AccountDTO;
import cn.conque.hmily.demo.dubbo.account.api.dto.AccountNestedDTO;
import cn.conque.hmily.demo.dubbo.account.api.entity.AccountDO;


public interface AccountService {


    /**
     * 扣款支付
     *
     * @param accountDTO 参数dto
     * @return true
     */
    @Hmily
    void payment(AccountDTO accountDTO);

    boolean testPayment(AccountDTO accountDTO);

    /**
     * 扣款支付
     *
     * @param accountNestedDTO 参数dto
     * @return true
     */
    @Hmily
    boolean paymentWithNested(AccountNestedDTO accountNestedDTO);


    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO
     */
    AccountDO findByUserId(String userId);
}
