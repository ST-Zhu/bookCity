package com.stzhu.dao;

import com.stzhu.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    /**
     * 保存订单详细信息到数据库
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);

    List<OrderItem> queryById(String orderId);
}
