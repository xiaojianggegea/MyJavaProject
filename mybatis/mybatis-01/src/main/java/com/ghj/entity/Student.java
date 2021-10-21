package com.ghj.entity;

import java.util.Date;

/**
 * @program: mybatis
 * @description: 学生类
 * @author: 小江
 * @create: 2021-10-12 16:12
 **/

public class Student {
    private int id;
    private String name;
    private String email;
    private Date dob;

    public Student() {
    }

    public Student(int id, String name, String email, Date dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
