package com.zhong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {
    private int id;
    private Integer bookId;
    private Integer userId;
    private Date borrowDate;
    private Date revertDate;
    private Integer createBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;

    private String bookName;
    private String userName;
}
