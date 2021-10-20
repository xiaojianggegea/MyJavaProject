package com.ghj.dao;

import com.ghj.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @description: 操作数据库
 * @author: 小江
 * @create: 2021-10-12 16:42
 **/
public interface StudentMapper {
    List<Student> findAllStudents();
    Student findStudentById(int id);
    int insertStudent(Student student);
    int updateStudent(Student student);
    Map<String,Object> findStudentOne(int id);
    List<Map<String,Object>> findStudentMore();
}
