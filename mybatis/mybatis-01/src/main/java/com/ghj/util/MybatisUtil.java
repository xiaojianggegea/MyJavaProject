package com.ghj.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @program: mybatis
 * @description: Mybatis工具类
 * @author: 小江
 * @create: 2021-10-12 16:26
 **/

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactory(){
        try {
            InputStream inputStream;
//            获取sqlSessionFactory对象
            String resources = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resources);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

//    获取SqlSession实例，包含了面向数据库执行Sql语句的所有方法
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }
    public static SqlSession getSqlSession(boolean autoCommit){
        return getSqlSessionFactory().openSession(autoCommit);
    }
}
