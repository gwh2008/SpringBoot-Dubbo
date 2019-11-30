
package org.dromara.hmily.demo.dubbo.account.service;

import cn.conque.hmily.demo.dubbo.account.api.dto.AccountDTO;
import cn.conque.hmily.demo.dubbo.account.api.dto.AccountNestedDTO;
import cn.conque.hmily.demo.dubbo.account.api.entity.AccountDO;
import cn.conque.hmily.demo.dubbo.account.api.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.dromara.hmily.annotation.Hmily;
import org.dromara.hmily.demo.dubbo.account.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Account service.
 *
 * 账号服务
 */
@Service
public class AccountServiceImpl implements AccountService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    /**
     * The Trycount.
     */
    private static AtomicInteger trycount = new AtomicInteger(0);

    /**
     * The Confrim count.
     */
    private static AtomicInteger confrimCount = new AtomicInteger(0);

    private final AccountMapper accountMapper;

    /**
     * Instantiates a new Account service.
     *
     * @param accountMapper the account mapper
     */
    @Autowired(required = false)
    public AccountServiceImpl(final AccountMapper accountMapper) {
        this.accountMapper = accountMapper;

    }

    @Override
    @Hmily(confirmMethod = "confirm", cancelMethod = "cancel")
    public void payment(AccountDTO accountDTO) {
        accountMapper.update(accountDTO);
    }

    @Override
    public boolean testPayment(AccountDTO accountDTO) {
        accountMapper.update(accountDTO);
        return Boolean.TRUE;
    }

    @Override
    @Hmily(confirmMethod = "confirmNested", cancelMethod = "cancelNested")
    @Transactional(rollbackFor = Exception.class)
    public boolean paymentWithNested(AccountNestedDTO accountNestedDTO) {
        AccountDTO dto = new AccountDTO();
        dto.setAmount(accountNestedDTO.getAmount());
        dto.setUserId(accountNestedDTO.getUserId());
        accountMapper.update(dto);
        return Boolean.TRUE;
    }

    @Override
    public AccountDO findByUserId(String userId) {
        return accountMapper.findByUserId(userId);
    }

    /**
     * Confirm nested boolean.
     *
     * @param accountNestedDTO the account nested dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirmNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.debug("============dubbo tcc 执行确认付款接口===============");
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(accountNestedDTO.getUserId());
        accountDTO.setAmount(accountNestedDTO.getAmount());
        accountMapper.confirm(accountDTO);
        return Boolean.TRUE;
    }

    /**
     * Cancel nested boolean.
     *
     * @param accountNestedDTO the account nested dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.debug("============ dubbo tcc 执行取消付款接口===============");
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(accountNestedDTO.getUserId());
        accountDTO.setAmount(accountNestedDTO.getAmount());
        accountMapper.cancel(accountDTO);
        return Boolean.TRUE;
    }

    /**
     * Confirm boolean.
     *
     * @param accountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(AccountDTO accountDTO) {
        LOGGER.info("============dubbo tcc 执行确认付款接口===============");
        accountMapper.confirm(accountDTO);
        final int i = confrimCount.incrementAndGet();
        LOGGER.info("调用了account confirm " + i + " 次");
        return Boolean.TRUE;
    }


    /**
     * Cancel boolean.
     *
     * @param accountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(AccountDTO accountDTO) {
        LOGGER.info("============ dubbo tcc 执行取消付款接口===============");
        final AccountDO accountDO = accountMapper.findByUserId(accountDTO.getUserId());
        accountMapper.cancel(accountDTO);
        return Boolean.TRUE;
    }
}
