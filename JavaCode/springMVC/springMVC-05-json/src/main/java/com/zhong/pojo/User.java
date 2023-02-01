package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Data
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private  String sex;
}
