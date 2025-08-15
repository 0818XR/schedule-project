package com.qiubai.schedule.dao.impl;

import com.qiubai.schedule.dao.BaseDao;
import com.qiubai.schedule.dao.SysScheduleDao;
import com.qiubai.schedule.pojo.SysSchedule;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "INSERT into sys_schedule values(DEFAULT,?,?,?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }
}
