package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: ServletTest
 * @description: servlet测试类
 * @author: 小江
 * @create: 2021-10-14 20:06
 **/
@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("test...");
        resp.getWriter().println("你好张三");
    }
}
