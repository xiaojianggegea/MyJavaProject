package com.ghj.dao;

import com.ghj.entity.*;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: mybatis
 * @description: 一对一测试
 * @author: 小江
 * @create: 2021-10-21 13:58
 **/

public class StudentMapperShineUponTest {
    //    一对一测试
    @Test
    public void test01() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentOneToOneMapper studentOneToOneMapper =
                sqlSession.getMapper(StudentOneToOneMapper.class);
        StudentOneToOne studentOneToOne =
                studentOneToOneMapper.selectStudentWithAddress(1);
        System.out.println(studentOneToOne);
        System.out.println(studentOneToOne.getAddress());
    }

    //    一对多测试
    @Test
    public void test02() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentOneToManyMapper studentOneToManyMapper =
                sqlSession.getMapper(StudentOneToManyMapper.class);
        Tutor tutor = studentOneToManyMapper.findTutorById(1);
        System.out.println(tutor);
        List<Courses> courses = tutor.getCourses();
        courses.forEach(System.out::println);
    }

    //    多对多插入学生数据
    @Test
    public void test03() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        StudentManyToMany studentManyToMany = new StudentManyToMany("张三", "男", "计算机", "大四");
        int n = studentManyToManyMapper.insertStudent(studentManyToMany);
        if (n > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //    多对多插入课程数据
    @Test
    public void test04() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        Course course1 = new Course("001", "corejava");
        Course course2 = new Course("002", "oracle");
        studentManyToManyMapper.insertCourse(course1);
        int n = studentManyToManyMapper.insertCourse(course2);
        if (n > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //    多对多通过ID查询学生数据
    @Test
    public void test05() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        StudentManyToMany studentManyToMany = studentManyToManyMapper.getStudentById(21);
        System.out.println(studentManyToMany);

    }

    //    多对多通过ID查询课程数据
    @Test
    public void test06() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        Course course = studentManyToManyMapper.getCourseById(22);
        System.out.println(course);
    }

    //    多对多插入数据
    @Test
    public void test07() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        StudentManyToMany studentManyToMany = studentManyToManyMapper.getStudentById(21);
        Course course = studentManyToManyMapper.getCourseById(22);
        studentManyToManyMapper.studentSelectCourse(studentManyToMany, course);
        sqlSession.commit();
        sqlSession.close();
    }

    //    查询比指定ID小的信息
    @Test
    public void test08() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        List<StudentManyToMany> list = studentManyToManyMapper.getStudentByIdOnCondition(23);
        list.forEach(System.out::println);
    }

    //    查询student级联查询出所选的course并且组装成完整的对象
    @Test
    public void test09() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentManyToManyMapper studentManyToManyMapper =
                sqlSession.getMapper(StudentManyToManyMapper.class);
        StudentManyToMany studentManyToMany = studentManyToManyMapper.getStudentByIdWithCourses(21);
        System.out.println(studentManyToMany);
    }
}
