package com.ghj.dao;

import com.ghj.entity.StudentOne;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis
 * @description: 测试类
 * @author: 小江
 * @create: 2021-10-12 17:01
 **/

public class StudentMapperTest {
    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    //    查询全部信息测试
    @Test
    public void test1() {
        //    第一步：获取sqlSession对象
        logger.debug("获取sqlSession对象");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
//    getMapper
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        logger.debug("查询全部信息方法执行......");
        logger.debug("获取到List集合");
        List<StudentOne> stuList = studentMapper.findAllStudents();
        for (StudentOne stu : stuList) {
            logger.debug("查询成功！");
            System.out.println(stu);
        }
        sqlSession.close();
    }

    //    根据ID查询信息测试
    @Test
    public void test2() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
        StudentOne student = studentDao.findStudentById(3);
        System.out.println(student);
        sqlSession.close();
    }

    //    插入信息操作测试
    @Test
    public void test3() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentDao = sqlSession.getMapper(StudentMapper.class);
        StudentOne student = new StudentOne(3, "tom", "sdfksdfsd", new Date());
        int n = studentDao.insertStudent(student);
        if (n > 0) {
            System.out.println("插入成功！");
        } else {
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
        StudentOne student = new StudentOne();
        student.setName("jack");
        student.setEmail("2314395857@qq.com");
        student.setDob(new Date());
        int n = sqlSession.insert("com.ghj.dao.StudentMapper.string-instertStudent", student);
        if (n > 0) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }
//      通过id修改信息
    @Test
    public void test5() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        StudentOne student = new StudentOne();
        student.setId(1);
        student.setName("ghj");
        student.setEmail("123456@qq.com");
        student.setDob(new Date());
//      通过字符串的形式调用映射SQL语句
//      int n = sqlSession.update("com.ghj.dao.StudentMapper.updateStudent",student);
        int n = studentMapper.updateStudent(student);
        if (n > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
//    查出一条数据放入map集合
    @Test
    public void test6() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        StudentOne student = new StudentOne();
        student.setId(1);
        Map<String,Object> map= studentMapper.findStudentOne(1);
        map.forEach((k,v)-> System.out.println(k+"="+v));
        sqlSession.close();
    }
//    查出多条数据放入map集合
    @Test
    public void test7() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Map<String,Object>> list = studentMapper.findStudentMore();
        list.forEach(map->{
            map.forEach((k,v)-> System.out.println(k+"="+v));
        });
        sqlSession.close();
    }

}
