
package org.dromara.hmily.demo.dubbo.order.service;

import org.dromara.hmily.demo.dubbo.order.entity.Order;


public interface PaymentService {

    /**
     * 订单支付
     *
     * @param order 订单实体
     */
    void makePayment(Order order);

    /**
     * Test make payment.
     *
     * @param order the order
     */
    void testMakePayment(Order order);


    /**
     * 订单支付
     *
     * @param order 订单实体
     */
    void makePaymentWithNested(Order order);

    /**
     * mock订单支付的时候库存异常
     *
     * @param order 订单实体
     * @return String string
     */
    String mockPaymentInventoryWithTryException(Order order);


    /**
     * mock订单支付的时候库存超时
     *
     * @param order 订单实体
     * @return String string
     */
    String mockPaymentInventoryWithTryTimeout(Order order);


    /**
     * mock订单支付的时候库存确认异常
     *
     * @param order 订单实体
     * @return String string
     */
    String mockPaymentInventoryWithConfirmException(Order order);


    /**
     * mock订单支付的时候库存确认超时
     *
     * @param order 订单实体
     * @return String string
     */
    String mockPaymentInventoryWithConfirmTimeout(Order order);

}
