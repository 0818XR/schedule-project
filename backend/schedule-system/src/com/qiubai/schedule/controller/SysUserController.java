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
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
        int rows = userService.regist(sysUser);
        Result result = Result.ok(null);
        if(rows < 1) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    /**
     * 接收用户登录请求的业务处理方法(接口)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
//        用户名错误返回1 密码错误返回2 登录成功返回3
        int res = userService.login(sysUser);
        Result result = null;
        switch (res) {
            case 1 -> result = Result.build(null, ResultCodeEnum.USERNAME_USED);
            case 2 -> result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            case 3 -> result = Result.ok(null);
        }
        WebUtil.writeJson(resp, result);
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
