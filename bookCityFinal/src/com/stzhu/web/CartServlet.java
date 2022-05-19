package com.stzhu.web;

import com.google.gson.Gson;
import com.stzhu.bean.Book;
import com.stzhu.bean.Cart;
import com.stzhu.bean.CartItem;
import com.stzhu.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
    BookServiceImpl bsi = new BookServiceImpl();

/*    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bsi.selectById(Integer.valueOf(req.getParameter("id")));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }*/

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = bsi.selectById(Integer.valueOf(req.getParameter("id")));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        Gson gson = new Gson();
        Map<String, Object> res = new HashMap<>();
        res.put("lastName", cartItem.getName());
        res.put("countCart", cart.getTotalCount());
        resp.getWriter().write(gson.toJson(res));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int count = Integer.valueOf(req.getParameter("count"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.updateCount(id, count);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
