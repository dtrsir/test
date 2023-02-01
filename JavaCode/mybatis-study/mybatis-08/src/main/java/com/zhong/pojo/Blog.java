package com.zhong.pojo;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Blog {

    private String id;
    private  String title;
    private  String author;
    private Date createTime;
    private int views;



}
