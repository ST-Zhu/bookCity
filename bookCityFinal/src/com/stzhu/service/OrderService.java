package com.stzhu.service;

import com.stzhu.bean.Cart;
import com.stzhu.bean.Order;
import com.stzhu.bean.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    String createOrder(Cart cart, int userId);

    List<Order> showAllOrders();

    List<OrderItem> showOrderDetail(String orderId);

    void sendOrder(String orderId);

    List<Order> showMyOrders(int userId);

    void receiverOrder(String orderId);
}
