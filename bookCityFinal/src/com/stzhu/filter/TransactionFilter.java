package com.stzhu.filter;

import com.stzhu.utils.DBUtil;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            DBUtil.commitClose();
        } catch (Exception e) {
            DBUtil.rollbackClose();
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
