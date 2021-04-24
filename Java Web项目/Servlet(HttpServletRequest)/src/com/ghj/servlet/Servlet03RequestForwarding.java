package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest请求转发
 * 服务端行为
 * 存在一次请求
 * 地址栏不发生变化
 * request不共享
 */
@WebServlet("/ser03")
public class Servlet03RequestForwarding extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受客户端请求参数
        String username=req.getParameter("uname");
        System.out.println("Servlet03RequestForwarding:"+username);
    }
}
