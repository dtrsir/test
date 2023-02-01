package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    private int id;//用户id
    private String userCode;//用户账号
    private String userName;//用户名
    private String password;//用户密码
    private Integer gender;//性别
    private Date birthday;//生日
    private String phone;//电话
    private Integer userRole;//用户角色
    private Integer createBy;//创建者
    private Date creationDate;//创建日期
    private Integer modifyBy;//修改者
    private Date modifyDate;//修改日期

    private String roleName;//用户角色名
    private Integer age;//年龄
}
