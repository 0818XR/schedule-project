package com.qiubai.schedule.dao.impl;

import com.qiubai.schedule.dao.BaseDao;
import com.qiubai.schedule.dao.SysScheduleDao;
import com.qiubai.schedule.pojo.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "INSERT into sys_schedule values(DEFAULT,?,?,?)";
        return baseUpdate(sql, schedule.getUid(), schedule.getTitle(), schedule.getCompleted());
    }

    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        String sql = "select sid,uid,title,completed from sys_schedule where uid = ?";
        List<SysSchedule> itemList = baseQuery(SysSchedule.class, sql, uid);
        return itemList;
    }

    @Override
    public Integer addDefault(int uid) {
        String sql = "insert into sys_schedule values (DEFAULT,?,'请输入日程',0)";
        return baseUpdate(sql,uid);
    }

    @Override
    public int updateSchedule(SysSchedule sysSchedule) {
        String sql = "update sys_schedule set title = ?,completed = ? where sid=?";
        return baseUpdate(sql, sysSchedule.getTitle(),sysSchedule.getCompleted(),sysSchedule.getSid());
    }

    @Override
    public Integer removeSchedule(SysSchedule sysSchedule) {
        String sql = "delete from sys_schedule where sid = ?";
        return baseUpdate(sql, sysSchedule.getSid());
    }
}
