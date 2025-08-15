package com.qiubai.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.Session;
import com.qiubai.schedule.common.Result;
import com.qiubai.schedule.common.ResultCodeEnum;
import com.qiubai.schedule.pojo.SysUser;
import com.qiubai.schedule.service.SysUserService;
import com.qiubai.schedule.service.impl.SysUserServiceImpl;
import com.qiubai.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController{
    private final SysUserService userService = new SysUserServiceImpl();

    /**
     * 接收用户注册请求的业务处理方法(接口)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);
        if(rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }

    /**
     * 接收用户登录请求的业务处理方法(接口)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = new SysUser(null, username, userPwd);
        int result = userService.login(sysUser);
        switch (result) {
            case 1 -> resp.sendRedirect("/loginUsernameError.html");
            case 2 -> resp.sendRedirect("/loginUserPwdError.html");
            case 3 -> {
                HttpSession session = req.getSession();
                // 此处使用的sysUser中没有uid，在后面使用此session时需要注意
                session.setAttribute("sysUser",sysUser);
                resp.sendRedirect("/showSchedule.html");
            }
        }
    }

    /**
     * 检查用户名是否被占用，返回用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        boolean canUse = userService.checkUsernameUsed(username);
        Result result = Result.ok(null);
        if(!canUse) {
            result=Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }
}
