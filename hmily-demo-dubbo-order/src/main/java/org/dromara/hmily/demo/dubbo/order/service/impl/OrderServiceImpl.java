
package org.dromara.hmily.demo.dubbo.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.dromara.hmily.demo.dubbo.order.entity.Order;
import org.dromara.hmily.demo.dubbo.order.enums.OrderStatusEnum;
import org.dromara.hmily.demo.dubbo.order.mapper.OrderMapper;
import org.dromara.hmily.demo.dubbo.order.service.OrderService;
import org.dromara.hmily.demo.dubbo.order.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单实现
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderMapper orderMapper;

    private final PaymentService paymentService;

    @Autowired(required = false)
    public OrderServiceImpl(OrderMapper orderMapper,
                            PaymentService paymentService) {
        this.orderMapper = orderMapper;
        this.paymentService = paymentService;
    }

    @Override
    public String orderPay(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            final long start = System.currentTimeMillis();
            paymentService.makePayment(order);
            System.out.println("切面耗时：" + (System.currentTimeMillis() - start));
        }
       /* final long start = System.currentTimeMillis();
        paymentService.makePayment(new Order());
        System.out.println("切面耗时：" + (System.currentTimeMillis() - start));*/
        return "success";
    }

    @Override
    public String testOrderPay(Integer count, BigDecimal amount) {
       /* final Order order = buildTestOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            final long start = System.currentTimeMillis();
            paymentService.testMakePayment(order);
            System.out.println("方法耗时：" + (System.currentTimeMillis() - start));
        }*/

        final long start = System.currentTimeMillis();
        paymentService.testMakePayment(new Order());
        System.out.println("方法耗时：" + (System.currentTimeMillis() - start));
        return "success";
    }

    /**
     * 创建订单并且进行扣除账户余额支付，并进行库存扣减操作
     * in this  Inventory nested in account.
     *
     * @param count  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String orderPayWithNested(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.makePaymentWithNested(order);
        }
        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在try阶段中的库存异常
     *
     * @param count  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String mockInventoryWithTryException(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.mockPaymentInventoryWithTryException(order);
        }
        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在try阶段中的timeout
     *
     * @param count  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String mockInventoryWithTryTimeout(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.mockPaymentInventoryWithTryTimeout(order);
        }
        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在Confirm阶段中的异常
     *
     * @param count  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    @Transactional
    public String mockInventoryWithConfirmException(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.mockPaymentInventoryWithConfirmException(order);
        }
        return "success";
    }

    /**
     * 模拟在订单支付操作中，库存在Confirm阶段中的timeout
     *
     * @param count  购买数量
     * @param amount 支付金额
     * @return string
     */
    @Override
    public String mockInventoryWithConfirmTimeout(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        final int rows = orderMapper.save(order);
        if (rows > 0) {
            paymentService.mockPaymentInventoryWithConfirmTimeout(order);
        }
        return "success";
    }

    @Override
    public void updateOrderStatus(Order order) {
        orderMapper.update(order);
    }

    private Order buildOrder(Integer count, BigDecimal amount) {
        Order order = new Order();
        order.setCreateTime(new Date());
        //demo中的表里只有商品id为1的数据
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        order.setTotalAmount(amount);
        order.setCount(count);
        //demo中 表里面存的用户id为10000
        order.setUserId("10000");
        return order;
    }

    private Order buildTestOrder(Integer count, BigDecimal amount) {
        Order order = new Order();
        order.setCreateTime(new Date());
        //demo中的表里只有商品id为1的数据
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
        order.setTotalAmount(amount);
        order.setCount(count);
        //demo中 表里面存的用户id为10000
        order.setUserId("10000");
        return order;
    }
}
