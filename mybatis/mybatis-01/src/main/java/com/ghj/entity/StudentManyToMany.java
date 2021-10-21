package com.ghj.entity;

import java.util.List;

/**
 * @program: mybatis
 * @description: 学生类
 * @author: 小江
 * @create: 2021-10-21 19:34
 **/

public class StudentManyToMany {
    private Integer id;
    private String name; // 姓名
    private String gender; // 性别
    private String major; // 专业
    private String grade; // 年级
    private List<Course> courses;// 所选的课程

    public StudentManyToMany() {

    }

    public StudentManyToMany(String name, String gender, String major, String grade) {
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentManyToMany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", courses=" + courses +
                '}';
    }
}
