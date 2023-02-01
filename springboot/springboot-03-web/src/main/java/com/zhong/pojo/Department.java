package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*伪造的部门表*/
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
