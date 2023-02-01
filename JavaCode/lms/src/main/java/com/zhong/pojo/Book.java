package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {
    private int id;
    private String bookName;
    private String author;
    private String publisher;//出版社
    private Date publicTime;//出版时间
    private BigDecimal price;
    private Integer stock;//库存
    private Integer createBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;



}