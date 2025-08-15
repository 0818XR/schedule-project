package com.qiubai.schedule.filters;

import com.qiubai.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
        * 1 servlet参数父转子，以使用更多方法
        *
        * 2 获得session域对象
        * 从session中获得登录用户对象
        *
        * 3 判断用户对象是否为空
        * 没登录 -> 跳转到 login.html
        * 登录  -> 放行
        * */

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");

        if (sysUser == null) {
            resp.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
