package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 *    服务端指导，客户端行为
 *    存在两次请求
 *    地址栏发生变化
 *    respones不共享
 */
@WebServlet("/ser03")
public class Servlet03HttpServletResponseRedirect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet03HttpServletResponseRedirect......");
        resp.getWriter().write("Servlet03HttpServletResponseRedirect......");
        //重定向到ser04
        resp.sendRedirect("ser04");
    }
}
