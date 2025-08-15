package com.qiubai.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 当前类作为所有controller类的父类，封装了service方法，可供所有类调用
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();    // uri : /schedule/*
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
//      使用反射进行方法调用
        Class aClass = this.getClass();
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            declaredMethod.setAccessible(true);

            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        使用if else进行方法的选择调用
//        if (methodName.equals("add")) {
//            //增加操作
//            add(req, resp);
//        } else if (methodName.equals("find")) {
//            //查询操作
//            find(req, resp);
//        } else if (methodName.equals("update")) {
//            //修改操作
//            update(req, resp);
//        } else if (methodName.equals("remove")) {
//            //删除操作
//            remove(req, resp);
//        }
    }
}
