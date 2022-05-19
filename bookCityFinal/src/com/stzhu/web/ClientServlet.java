package com.stzhu.web;

import com.stzhu.bean.Page;
import com.stzhu.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends BaseServlet {
    private BookServiceImpl bsi = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page = new Page();
        page.setUrl("client/ClientServlet?action=page");
        page.setPageNo(Integer.valueOf(req.getParameter("pageNo")));
        bsi.page(page);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page = new Page();
        int min = Integer.valueOf(req.getParameter("min"));
        int max = Integer.valueOf(req.getParameter("max"));
        page.setUrl("client/ClientServlet?action=pageByPrice&min=" + min + "&max=" + max);
        page.setPageNo(Integer.valueOf(req.getParameter("pageNo")));
        bsi.pageByPrice(page, min, max);
        req.setAttribute("page", page);
        req.setAttribute("min", min);
        req.setAttribute("max", max);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
