package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/*员工表*/
@Data
@ToString
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer sex; //0:女   1：男

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer sex, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        /*默认创建日期*/
        this.birth = new Date();
    }
}
