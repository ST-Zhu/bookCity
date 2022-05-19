package com.stzhu.web;

import com.stzhu.bean.Cart;
import com.stzhu.bean.Order;
import com.stzhu.bean.OrderItem;
import com.stzhu.bean.User;
import com.stzhu.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderServiceImpl osi = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();
        req.getSession().setAttribute("orderId", osi.createOrder(cart, userId));
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = osi.showAllOrders();
        req.getSession().setAttribute("orderList", orderList);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = (String) req.getParameter("orderId");
        List<OrderItem> orderItems = osi.showOrderDetail(orderId);
        req.getSession().setAttribute("orderItems", orderItems);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = (String) req.getParameter("orderId");
        osi.sendOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.valueOf(req.getParameter("userId"));
        List<Order> myOrders = osi.showMyOrders(userId);
        req.getSession().setAttribute("myOrders", myOrders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }

    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = (String) req.getParameter("orderId");
        osi.receiverOrder(orderId);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
