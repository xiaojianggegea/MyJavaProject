package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie路径
 *     1、当前服务器下任何项目的任意资源都可获取Cookie对象
 *     2、当前项目下的资源可获取Cookie对象（默认不设置Cookie的Path）
 *     3、指定项目下的资源可获取Cookie对象
 *     4、指定目录下的资源可获取Cookie对象
 */
@WebServlet("/cookie05")
public class Servlet05CookieRoute extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1、当前服务器下任何项目的任意资源都可获取Cookie对象*/
        Cookie cookie01=new Cookie("cookie01","cookie01");
        //设置路径为”/“，表示在当前服务器下任何项目的任意资源都可获取Cookie对象
        cookie01.setPath("/");
        //发送Cookie
        resp.addCookie(cookie01);

        /*2、当前项目下的资源可获取Cookie对象（默认不设置Cookie的Path）*/
        Cookie cookie02=new Cookie("cookie02","cookie02");
        //发送（响应）Cookie对象
        resp.addCookie(cookie02);

        /*3、指定项目下的资源可获取Cookie对象*/
        Cookie cookie03=new Cookie("cookie03","cookie03");
        //设置指定项目的站点名
        cookie03.setPath("/servlet");
        //发送Cookie
        resp.addCookie(cookie03);

        /*4、指定目录下的资源可获取Cookie对象*/
        Cookie cookie04=new Cookie("cookie04","cookie04");
        //设置指定项目的站点名
        cookie04.setPath("/ServletCookie/cookie01");
        //发送Cookie
        resp.addCookie(cookie04);
    }
}
