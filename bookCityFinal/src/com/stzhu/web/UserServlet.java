package com.stzhu.web;

import com.google.gson.Gson;
import com.stzhu.bean.User;
import com.stzhu.service.UserServiceImpl;
import com.stzhu.utils.WebUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserServiceImpl usi = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (usi.exist(username)) {
            User user = usi.login(new User(username, password));
            if (user != null) {
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            } else {
//                System.out.println("用户名或密码错误。");
                req.setAttribute("msg", "用户名或密码错误");
                req.setAttribute("username", username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }
        } else {
//            System.out.println("用户名" + username + "不存在。");
            req.setAttribute("msg", "用户名" + username + "不存在");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = new User();

        WebUtil.populate(user, req.getParameterMap());
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if ((token != null) && (token.equals(code))) {
            if (!usi.exist(username)) {
                usi.register(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
//                System.out.println("用户名" + username +"已存在");
                req.setAttribute("msg", "用户名" + username +"已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
        } else {
//            System.out.println("验证码错误");
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void existUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existName = usi.exist(username);
        Map<String, Boolean> res = new HashMap<>();
        res.put("existName", existName);
        Gson gson = new Gson();
        String json = gson.toJson(res);
        resp.getWriter().write(json);
    }
}
