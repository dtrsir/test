package com.zhong.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
