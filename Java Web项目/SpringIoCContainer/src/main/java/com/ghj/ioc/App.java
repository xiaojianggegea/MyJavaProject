package com.ghj.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 输出save()
 */
public class App {
    @Test
    public void deom() throws BeansException {
        //配置文件路径
        String xmlPath= "applicationContext.xml";
        //初始化sping容器，加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        //获取容器获取userDao实例
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        userDao.save();
    }
}
