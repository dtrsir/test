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
    public int id;
    public Integer bookId;
    public Integer userId;
    public Date borrowDate;
    public Date revertDate;
    public Integer createBy;
    public Date creationDate;
    public Integer modifyBy;
    public Date modifyDate;
}
