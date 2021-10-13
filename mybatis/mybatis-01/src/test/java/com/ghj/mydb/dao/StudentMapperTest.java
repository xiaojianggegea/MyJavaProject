package com.ghj.mydb.dao;

import com.ghj.dao.StudentMapper;
import com.ghj.entity.Student;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @program: mybatis
 * @description: 测试类
 * @author: 小江
 * @create: 2021-10-12 17:01
 **/

public class StudentMapperTest {
    @Test
    public void test1() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
//    getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuList = studentMapper.findAllStudents();
        for (Student stu : stuList) {
            System.out.println(stu);
        }
        sqlSession.close();
    }
    @Test
    public void test2() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
        Student student = studentDao.findStudentById(3);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void test3() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student(3,"tom","sdfksdfsd",new Date());
        int n = studentDao.insertStudent(student);
        if (n>0){
            System.out.println("插入成功！");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}