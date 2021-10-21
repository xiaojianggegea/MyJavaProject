package com.ghj.entity;

import java.util.Date;

/**
 * @program: mybatis
 * @description: 科目类
 * @author: 小江
 * @create: 2021-10-21 16:55
 **/

public class Course {
    private Integer courseId;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    public Course(){

    }

    public Course(Integer courseId, String name, String description, Date startDate, Date endDate) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "学科ID：" + courseId +" "+
                "科目名：" + name + " " +
                "科目描述：" + description + " " +
                "开始时间：" + startDate +" "+
                "结束时间：" + endDate;
    }
}
