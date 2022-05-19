package com.stzhu.dao;

import com.stzhu.bean.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 保存订单到数据库
     * @param order
     * @return
     */
    int saveOrder(Order order);

    List<Order> queryOrders();

    void sendStatus(String orderId);

    List<Order> queryOrdersByUserId(int userId);

    void receiverStatus(String orderId);
}
