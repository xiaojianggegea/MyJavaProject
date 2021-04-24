package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ser05")
public class Servlet05RequestScope extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet05RequestScope......");
        //获取域对象内容
        String name= (String) req.getAttribute("name");
        System.out.println("name"+name);
        resp.getWriter().write("name"+name);

        String age= (String) req.getAttribute("age");
        System.out.println("age"+age);
        resp.getWriter().write("age"+age);
/*
        List<String> list= (List<String>) req.getAttribute("list");
        System.out.println(list.get(0));
        resp.getWriter().write(list.get(0));
 */
    }
}
