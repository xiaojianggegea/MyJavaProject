package com.ghj.service.impl;

import com.ghj.service.LoginService;

/**
 * @program: AutoLogin
 * @description: 登录服务层实现类
 * @author: 小江
 * @create: 2021-10-15 17:10
 **/

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(String username, String password) {
        return "ghj".equals(username) && "1234".equals(password);
    }
}
