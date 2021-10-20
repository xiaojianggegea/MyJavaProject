package com.ghj.dao;

import com.ghj.entity.Student;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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
    private static Logger logger = Logger.getLogger(StudentMapperTest.class);
    @Test
    public void test1() {
        //    第一步：获取sqlSession对象
        logger.debug("获取sqlSession对象");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
//    getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        logger.debug("查询全部信息方法执行......");
        logger.debug("获取到List集合");
        List<Student> stuList = studentMapper.findAllStudents();
        for (Student stu : stuList) {
            logger.debug("查询成功！");
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
        }else{
            System.out.println("插入失败！");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }
//    通过字符串的形式调用映射SQL语句(id实现了自动增长)
    @Test
    public void test4() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Student student = new Student();
        student.setName("jack");
        student.setEmail("2314395848@qq.com");
        student.setDob(new Date());
        int n = sqlSession.insert("com.ghj.dao.StudentMapper.string-instertStudent",student);
        if (n>0){
            System.out.println("插入成功！");
        }else{
            System.out.println("插入失败！");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
