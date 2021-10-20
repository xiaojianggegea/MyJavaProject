package com.ghj.uitl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: AutoLogin
 * @description: cookie取值
 * @author: 小江
 * @create: 2021-10-16 17:06
 **/

public class CookieUitl {
    public static String getCookieValByKey(String key, HttpServletRequest request) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!= null && cookies.length>0) {
            for (Cookie cookie : cookies) {
                if(key.equals(cookie.getName())){
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }
}
