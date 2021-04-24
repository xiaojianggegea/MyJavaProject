package com.ghj.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie的创建和发送
 */
@WebServlet("/cookiie01")
public class Servlet01Cookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        //创建Coookie
        Cookie cookie = new Cookie("name", "郭怀江");
        //发送（响应）Cookie对象
        resp.addCookie(cookie);
    }
}