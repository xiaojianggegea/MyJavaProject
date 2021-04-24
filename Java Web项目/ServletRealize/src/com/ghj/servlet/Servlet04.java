package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * doGet、doPost方法调用
 */
@WebServlet("/ser04")
public class Servlet04 extends HttpServlet {
    //第一种方法
    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.printlf("service...");
    }*/
    //第二种方法
    /**
     * Get请求调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get请求...");
        /*中文乱码解决*/
        resp.setContentType("application/json;charset=utf-8");
        String result = "Get请求...";
        resp.getWriter().write(new String(result.getBytes(), "UTF-8"));
    }

    /**
     * Post请求调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post请求...");
        resp.getWriter().write("Post请求...");
        //调用doGet方法
        doGet(req,resp);
    }
}
