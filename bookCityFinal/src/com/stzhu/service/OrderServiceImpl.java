package com.stzhu.service;

import com.stzhu.bean.Cart;
import com.stzhu.bean.CartItem;
import com.stzhu.bean.Order;
import com.stzhu.bean.OrderItem;
import com.stzhu.dao.OrderDaoImpl;
import com.stzhu.dao.OrderItemDaoImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDaoImpl odi = new OrderDaoImpl();
    private OrderItemDaoImpl oidi = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, int userId) {
        String orderId = String.valueOf(System.currentTimeMillis() + userId);
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        odi.saveOrder(order);
        for (Map.Entry<Integer, CartItem> element: cart.getItems().entrySet()) {
            CartItem cartItem = element.getValue();
            OrderItem orderItem = new OrderItem(cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            oidi.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return odi.queryOrders();
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return oidi.queryById(orderId);
    }

    @Override
    public void sendOrder(String orderId) {
        odi.sendStatus(orderId);
    }

    @Override
    public List<Order> showMyOrders(int userId) {
        return odi.queryOrdersByUserId(userId);
    }

    @Override
    public void receiverOrder(String orderId) {
        odi.receiverStatus(orderId);
    }
}
