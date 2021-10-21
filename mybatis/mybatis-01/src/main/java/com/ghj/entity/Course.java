package com.ghj.entity;

import java.util.List;

/**
 * @program: mybatis
 * @description: 课程类
 * @author: 小江
 * @create: 2021-10-21 19:34
 **/

public class Course {
    private Integer id;
    private String courseCode; // 课程编号
    private String courseName;// 课程名称
    private List<StudentManyToMany> students;// 选课学生

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<StudentManyToMany> getStudents() {
        return students;
    }

    public void setStudents(List<StudentManyToMany> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", students=" + students +
                '}';
    }
}
