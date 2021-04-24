package com.ghj.ioc;

/**
 * 第一种
 */
public class UserDaoImpl01 implements UserDao {
    @Override
    public void save() {
        System.out.println("The First ImplementationOf IoC Program！");
    }
}
