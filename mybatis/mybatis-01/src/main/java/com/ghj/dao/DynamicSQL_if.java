package com.ghj.dao;

import com.ghj.entity.Courses;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @description: 动态SQL-if
 * @author: 小江
 * @create: 2021-10-22 14:58
 **/
public interface DynamicSQL_if {
    List<Courses> searchCourses(Map<String, Object> map);
}
