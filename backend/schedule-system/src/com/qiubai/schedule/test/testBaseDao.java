package com.qiubai.schedule.test;

import com.qiubai.schedule.dao.BaseDao;
import com.qiubai.schedule.pojo.SysUser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class testBaseDao {

    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        String sql = "SELECT COUNT(1) FROM sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery() {
        String sql = "SELECT uid,username,user_pwd as userPwd FROM sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "INSERT into sys_schedule values(DEFAULT,?,?,?)";
        int rows = baseDao.baseUpdate(sql,1, "学习JAVA", 0);
        System.out.println(rows);
    }
}
