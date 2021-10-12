package com.ghj.mydb.dao;

import com.ghj.dao.StudentDao;
import com.ghj.entity.Student;
import com.ghj.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @program: mybatis
 * @description: 测试类
 * @author: 小江
 * @create: 2021-10-12 17:01
 **/

public class StudentDaoTest {
    @Test
    public void test() {
        //    第一步：获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
//    getMapper
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> stuList = studentDao.getStudentList();
        for (Student stu : stuList) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

}
