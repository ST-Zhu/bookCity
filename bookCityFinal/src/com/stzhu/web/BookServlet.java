package com.stzhu.web;

import com.stzhu.bean.Book;
import com.stzhu.bean.Page;
import com.stzhu.service.BookServiceImpl;
import com.stzhu.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {
    private BookServiceImpl bsi = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        WebUtil.populate(book, req.getParameterMap());
        if (bsi.addBook(book)) {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + bsi.pageLast());
        } else {
            req.setAttribute("msg", "添加失败,请重新输入图书信息:");
            req.setAttribute("book", book);
            resp.sendRedirect(req.getContextPath() + "/pages/manager/book_edit.jsp");
        }
    }

    protected void revise(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int pageNo = Integer.valueOf(req.getParameter("pageNo"));
        Book book = new Book();
        WebUtil.populate(book, req.getParameterMap());
        if (bsi.reviseBook(id, book)) {
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
        } else {
            req.setAttribute("msg", "修改失败,请重新输入图书信息:");
            req.setAttribute("book", book);
            resp.sendRedirect(req.getContextPath() + "/pages/manager/book_edit.jsp");
        }
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int pageNo = Integer.valueOf(req.getParameter("pageNo"));
        Book book = bsi.selectById(id);
        req.setAttribute("book", book);
        req.setAttribute("pageNo", pageNo);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int pageNo = Integer.valueOf(req.getParameter("pageNo"));
        if (bsi.deleteBook(id)) {
            if (pageNo > bsi.pageLast()) {
                pageNo = bsi.pageLast();
            }
            resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
        } else {
            req.setAttribute("msg", "修改失败,请重新输入图书信息:");
            resp.sendRedirect(req.getContextPath() + "/pages/manager/book_edit.jsp");
        }
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Page page = new Page();
        page.setUrl("manager/bookServlet?action=page");
        page.setPageNo(Integer.valueOf(req.getParameter("pageNo")));
        bsi.page(page);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}


