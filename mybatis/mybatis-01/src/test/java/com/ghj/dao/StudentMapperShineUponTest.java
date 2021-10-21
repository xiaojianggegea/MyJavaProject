package com.ghj.dao;

import com.ghj.entity.StudentOneToOne;
import com.ghj.entity.Tutor;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @program: mybatis
 * @description: 一对一测试
 * @author: 小江
 * @create: 2021-10-21 13:58
 **/

public class StudentMapperShineUponTest {
//    一对一测试
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentOneToOneMapper studentOneToOneMapper = sqlSession.getMapper(StudentOneToOneMapper.class);
        StudentOneToOne studentOneToOne = studentOneToOneMapper.selectStudentWithAddress(1);
        System.out.println(studentOneToOne);
        System.out.println(studentOneToOne.getAddress());
    }
//    一对多测试
    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentOneToManyMapper studentOneToManyMapper = sqlSession.getMapper(StudentOneToManyMapper.class);
        Tutor tutor = studentOneToManyMapper.findTutorById(1);
        System.out.println(tutor);
        System.out.println(tutor.getAddress());
        System.out.println(tutor.getCourses());
    }
}
