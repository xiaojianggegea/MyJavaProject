package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie的到期时间
 *     1、负整数（默认值-1，表示只在浏览器内存中存活，关闭浏览器失效）
 *     2、正整数（表示存活指定秒数，将数据存在磁盘中）
 *     3、0（表示删除Cookie）
 *
 */
@WebServlet("/cookie03")
public class Servlet03CookieExpireDate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*到期时间，负整数（默认值-1，表示只在浏览器内存中存活，关闭浏览器失效）*/
        Cookie cookie1=new Cookie("name1","郭怀江");
        cookie1.setMaxAge(-1);
        resp.addCookie(cookie1);

        /*到期时间，正整数（表示存活指定秒数，将数据存在磁盘中）*/
        Cookie cookie2=new Cookie("name2","张三");
        cookie2.setMaxAge(10);
        resp.addCookie(cookie2);

        /*到期时间，0（表示删除Cookie）*/
        Cookie cookie3=new Cookie("name3","李四");
        cookie3.setMaxAge(0);
        resp.addCookie(cookie3);

    }
}
