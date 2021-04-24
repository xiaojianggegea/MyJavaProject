package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * request作用域
 *     通过该对象可以在一个请求中传递数据，
 *     作用范围：在一次请求中有效，即服务跳转有效。（请求转发时有效）
 *     //1、设置域对象内容
 *
 *
 */
@WebServlet("/ser04")
public class Servlet04RequestScope extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet04RequestScope......");
        //1、设置域对象内容
        req.setAttribute("name","郭怀江");

        req.setAttribute("age","19");

        List<String> list=new ArrayList<>();
        list.add("123456");
        req.setAttribute("list",list);

        //请求转发到Servlet05RequestScope
        /*req.getRequestDispatcher("ser05").forward(req,resp);*/

        //请求转发到DataPage.jsp页面
        req.getRequestDispatcher("DataPage.jsp").forward(req,resp);
    }
}
