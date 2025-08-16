package com.qiubai.schedule.service.impl;

import com.qiubai.schedule.dao.SysScheduleDao;
import com.qiubai.schedule.dao.impl.SysScheduleDaoImpl;
import com.qiubai.schedule.pojo.SysSchedule;
import com.qiubai.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {
    SysScheduleDao scheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        // 实现通过uid查找用户日程的功能

        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        return scheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public Integer removeSchedule(SysSchedule sysSchedule) {
        return scheduleDao.removeSchedule(sysSchedule);
    }
}
