package com.stzhu.dao;

import com.stzhu.bean.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(orderId,createTime,price,status,userId) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return selectList(Order.class, sql);
    }

    @Override
    public void sendStatus(String orderId) {
        String sql = "update t_order set status = ? where orderId = ?";
        update(sql, 1, orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(int userId) {
        String sql = "select * from t_order where userId = ?";
        return selectList(Order.class, sql, userId);
    }

    @Override
    public void receiverStatus(String orderId) {
        String sql = "update t_order set status = ? where orderId = ?";
        update(sql, 2, orderId);
    }
}
