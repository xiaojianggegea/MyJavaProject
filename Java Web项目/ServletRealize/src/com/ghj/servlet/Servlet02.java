package com.ghj.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 继承GenericServlet类...
 */
@WebServlet("/ser02")
public class Servlet02 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //打印在控制台上
        System.out.println("Inherit the GenericServlet class...");
        //通过流输出到浏览器上
        servletResponse.getWriter().write("Inherit the GenericServlet class...");
    }
}
