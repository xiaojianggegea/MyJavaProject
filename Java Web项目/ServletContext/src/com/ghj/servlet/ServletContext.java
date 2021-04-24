package com.ghj.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取ServletContext对象
 *     1、通过request对象获取
 *     2、通过Session对象获取
 *     3、通过ServletConfig对象获取
 *     4、直接获取
 * 常用方法
 *     1、获取当前服务器的版本信息
 *     2、获取项目的真实路径
 */
@WebServlet("/context01")
public class ServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        /*//通过request对象获取
        ServletContext servletContext1= (ServletContext) req.getServletContext();

        //通过Session对象获取
        ServletContext servletContext2= (ServletContext) req.getSession().getServletContext();

        //通过ServletConfig对象获取
        ServletContext servletContext3= (ServletContext) getServletConfig().getServletContext();

        //直接获取
        ServletContext servletContext4= (ServletContext) req.getServletContext();*/
        /*常用方法*/
        //1、获取当前服务器的版本信息
        String serverInfo=req.getServletContext().getServerInfo();
        System.out.println("当前服务器的版本信息:"+serverInfo);
        //2、获取项目的真实路径
        String realPath=req.getServletContext().getRealPath("/");
        System.out.println("项目的真实路径："+realPath);
    }
}
