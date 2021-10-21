package com.ghj.dao;

import com.ghj.entity.StudentOneToOne;

/**
 * @program: mybatis
 * @description: 一对一
 * @author: 小江
 * @create: 2021-10-21 13:46
 **/
public interface StudentOneToOneMapper {
    StudentOneToOne selectStudentWithAddress(int studId);
}
