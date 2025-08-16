package com.qiubai.schedule.dao;

import com.qiubai.schedule.pojo.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    /**
     * 该方法用于向数据库中增加一条日程记录
     * @param schedule 日程数据以SysSchedule实体类对象形式入参
     * @return  受影响的行数，值为0说明增加失败
     */
    int addSchedule(SysSchedule schedule);

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    int updateSchedule(SysSchedule sysSchedule);

    Integer removeSchedule(SysSchedule sysSchedule);
}
