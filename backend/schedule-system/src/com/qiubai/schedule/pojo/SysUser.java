package com.qiubai.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUser implements Serializable {
    /*
    * 1 每个属性都是私有的
    * 2 每个属性都要有getter setter方法
    * 3 必须有无参构造器，最好显式写出
    * 4 实现序列化接口
    * 5 重写hashcode和equals方法
    *
    * 使用lombok插件可以快速实现上述过程
    * Data注解可以实现 getter,setter,hashcode,equals,toString方法的重写
    * 此外还需要一条无参构造方法
    *
    * */
    private Integer uid;
    private String username;
    private String userPwd;
}
