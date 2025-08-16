package com.qiubai.schedule.service;

import com.qiubai.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 该接口定义了以sys_schedule表格为核心的业务处理功能
 */
public interface SysScheduleService {
    /**
     * 实现通过uid查找用户日程
     * @param uid 用户的uid
     * @return  返回一个sysSchedule的列表
     */
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer removeSchedule(SysSchedule sysSchedule);
}
