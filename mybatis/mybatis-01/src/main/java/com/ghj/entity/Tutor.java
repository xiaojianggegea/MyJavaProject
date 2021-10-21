package com.ghj.entity;

import java.util.List;

/**
 * @program: mybatis
 * @description: 教师类
 * @author: 小江
 * @create: 2021-10-21 16:56
 **/

public class Tutor {
    private Integer tutorId;
    private String name;
    private String email;
    private PhoneNumber phone;
    private Address address;
    private List<Course> courses;

    public Tutor(){

    }

    public Tutor(Integer tutorId, String name, String email, PhoneNumber phone, Address address, List<Course> courses) {
        this.tutorId = tutorId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.courses = courses;
    }

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneNumber getPhone() {
        return phone;
    }

    public void setPhone(PhoneNumber phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "教师ID：" + tutorId +" "+
                "教师姓名：" + name + " " +
                "邮件：" + email + " " +
                "电话号码：" + phone +" "+
                "地址：" + address +" "+
                "所教科目：" + courses;
    }
}
