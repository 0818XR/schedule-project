package com.qiubai.schedule.controller;

import com.qiubai.schedule.common.Result;
import com.qiubai.schedule.pojo.SysSchedule;
import com.qiubai.schedule.service.SysScheduleService;
import com.qiubai.schedule.service.impl.SysScheduleServiceImpl;
import com.qiubai.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        scheduleService.removeSchedule(sysSchedule);
        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        scheduleService.updateSchedule(sysSchedule);
        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);
        // 将结果放入result中并写成json串返回
        Result<List<SysSchedule>> result = Result.ok(itemList);
        WebUtil.writeJson(resp,result);
    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        scheduleService.addDefault(uid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
