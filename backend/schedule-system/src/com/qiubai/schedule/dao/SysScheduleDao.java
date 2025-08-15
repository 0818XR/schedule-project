package com.qiubai.schedule.dao;

import com.qiubai.schedule.pojo.SysSchedule;

public interface SysScheduleDao {
    /**
     * 该方法用于向数据库中增加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return  受影响的行数，值为0说明增加失败
     */
    int addSchedule(SysSchedule schedule);

}
