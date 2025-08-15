package com.qiubai.schedule.dao.impl;

import com.qiubai.schedule.dao.BaseDao;
import com.qiubai.schedule.dao.SysScheduleDao;
import com.qiubai.schedule.dao.SysUserDao;
import com.qiubai.schedule.pojo.SysSchedule;
import com.qiubai.schedule.pojo.SysUser;

import java.util.List;

public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addUser(SysUser user) {
        String sql = "INSERT into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql, user.getUsername(), user.getUserPwd());
    }

    @Override
    public List<SysUser> findByName(String username) {
        String sql = "SELECT uid, username, user_pwd as userPwd FROM sys_user WHERE username=?";
        return baseQuery(SysUser.class, sql, username);
    }
}
