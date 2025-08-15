package com.qiubai.schedule.dao;

import com.qiubai.schedule.pojo.SysUser;

import java.util.List;

public interface SysUserDao {
    /**
     * 该方法用于向数据库中增加用户
     * @param user 要注册的用户名和明文密码以SysUser对象的形式传入
     * @return  注册成功返回1 注册失败返回0
     */
    int addUser(SysUser user);

    /**
     * 该方法用于通过用户名查找用户
     * @param username 用户名
     * @return 返回查找到的用户信息列表
     */
    List<SysUser> findByName(String username);
}
