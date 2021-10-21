package com.ghj.dao;

import com.ghj.entity.StudentOne;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @description: 操作数据库
 * @author: 小江
 * @create: 2021-10-12 16:42
 **/
public interface StudentMapper {
//  StudentOne对象的操作
    List<StudentOne> findAllStudents();
    StudentOne findStudentById(int id);
    int insertStudent(StudentOne student);
    int updateStudent(StudentOne student);
    int deleteStudent(int id);
    Map<String,Object> findStudentOne(int id);
    List<Map<String,Object>> findStudentMore();
}
