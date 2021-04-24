package com.ghj.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 实现Servlet接口...
 */
@WebServlet("/ser03")
public class Servlet03 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        ////打印在控制台上
        System.out.println("实现Servlet接口...");
        //通过流输出到浏览器上
        /*中文乱码解决*/
        servletResponse.setContentType("application/json;charset=utf-8");
        String result = "实现Servlet接口...";
        servletResponse.getWriter().write(new String(result.getBytes(), "UTF-8"));
        //servletResponse.getWriter().write("实现Servlet接口...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
