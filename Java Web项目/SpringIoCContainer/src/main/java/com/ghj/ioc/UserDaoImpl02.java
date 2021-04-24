package com.ghj.ioc;

/**
 * 第二种
 */
public class UserDaoImpl02 implements UserDao{
    @Override
    public void save() {
        System.out.println("The Second WayToImplement IoC Programs!");
    }
}
