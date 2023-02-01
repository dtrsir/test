package com.zhong.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class Student {

    private int id;
    private String name;
    private Teacher teacher;
}
