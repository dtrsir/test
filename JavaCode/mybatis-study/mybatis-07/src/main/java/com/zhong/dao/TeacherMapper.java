package com.zhong.dao;

import com.zhong.pojo.Student;
import com.zhong.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
/*
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") int id);*/


    List<Teacher> getTeachers();

    //获取指定老师下的所有学生信息
    Teacher getTeacher(@Param("tid") int tid);



    Teacher getTeacher2(@Param("tid") int tid);
}
