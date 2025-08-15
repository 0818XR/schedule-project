package com.qiubai.schedule.service;

import com.qiubai.schedule.pojo.SysUser;

/**
 * 该接口定义了以sys_user表格为核心的业务处理功能
 */
public interface SysUserService {

    /**
     * 该方法读取传入的susUser参数进行注册操作
     * @param sysUser 要注册的用户名和明文密码以SysUser对象的形式传入
     * @return  注册成功返回1 注册失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 该方法读取传入的sysUser参数进行登录验证
     * @param sysUser 要登录的用户名和明文密码以SysUser对象的形式传入
     * @return  返回登录的用户信息
     */
    int login(SysUser sysUser);

    /**
     * 通过用户名找到用户
     * @param sysUser 要登录的用户名和明文密码以SysUser对象的形式传入
     * @return 返回找到的用户
     */
    SysUser findByUsername(SysUser sysUser);

    /**
     * 用于检查用户是否被占用
     * @param username 用户名
     * @return 返回int, 1 代表可用，0 代表不可用
     */
    boolean checkUsernameUsed(String username);
}


