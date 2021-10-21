package com.ghj.dao;

import com.ghj.entity.Course;
import com.ghj.entity.StudentManyToMany;

import java.util.List;

/**
 * @program: mybatis
 * @description: 多对多接口类
 * @author: 小江
 * @create: 2021-10-21 19:38
 **/

public interface StudentManyToManyMapper {
    //插入student数据
    int insertStudent(StudentManyToMany studentManyToMany);
    //插入course数据
    int insertCourse(Course course);
    //通过id查询学生
    StudentManyToMany getStudentById(Integer id);
    //通过id查询课程
    Course getCourseById(Integer id);
    //学生x选课y
    void studentSelectCourse(StudentManyToMany studentManyToMany, Course course);
    //查询比指定id值小的学生信息
    List<StudentManyToMany> getStudentByIdOnCondition(Integer id);
    //查询student级联查询出所选的course并且组装成完整的对象
    StudentManyToMany getStudentByIdWithCourses(Integer id);
}
