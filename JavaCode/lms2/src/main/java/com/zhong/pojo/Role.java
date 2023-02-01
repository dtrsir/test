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
public class Role {
    private int id;
    private String roleName;
    private Integer borrowTime;//可借阅天数
    private Integer createBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;

}
