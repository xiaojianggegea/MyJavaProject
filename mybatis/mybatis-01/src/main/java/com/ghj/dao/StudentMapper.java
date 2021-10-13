package com.ghj.dao;

import com.ghj.entity.Student;

import java.util.List;

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
}
