package com.qiubai.schedule.service.impl;

import com.qiubai.schedule.dao.BaseDao;
import com.qiubai.schedule.dao.SysUserDao;
import com.qiubai.schedule.dao.impl.SysUserDaoImpl;
import com.qiubai.schedule.pojo.SysUser;
import com.qiubai.schedule.service.SysUserService;
import com.qiubai.schedule.util.MD5Util;

import java.util.List;

public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        // 转换密文密码
        String userPwd = sysUser.getUserPwd();
        String pwd = MD5Util.encrypt(userPwd);
        sysUser.setUserPwd(pwd);

        // 处理注册业务逻辑
        return userDao.addUser(sysUser);

    }

    // 用户名错误返回1 密码错误返回2 登录成功返回3
    @Override
    public int login(SysUser sysUser) {
        // 转换为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        // 处理登录业务逻辑
        List<SysUser> list = userDao.findByName(sysUser.getUsername());
        if(list.isEmpty()) {
            return 1;
        } else if (!list.get(0).getUserPwd().equals(sysUser.getUserPwd())) {
            return 2;
        } else {

            return 3;
        }

    }

    @Override
    public SysUser findByUsername(SysUser sysUser) {
        List<SysUser> list = userDao.findByName(sysUser.getUsername());
        return list.get(0);
    }

    @Override
    public boolean checkUsernameUsed(String username) {
        List<SysUser> sysUsers = userDao.findByName(username);
        return sysUsers.isEmpty();
    }
}
