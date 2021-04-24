package com.ghj.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * 文件上传
 *        使用注解@MultipartConfig将一个Servlet标识为支持文件上传
 *        Servlet 将 multipart/form-data 的Post请求封装为Part对象，通过Part对上传的文件进行操作
 */
@WebServlet("/servlet")
@MultipartConfig  //如果是文件上传，必须设置该注解！
public class uploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("文件上传......");
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
        //获取表单参数
        String uname=req.getParameter("uname");
        System.out.println("uname:"+uname);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("uname:"+uname);

        //获取Part对象
        Part part=req.getPart("myfile");//file文件域的name属性值
        //通过Part对象获得上传的文件名
        String fileName=part.getSubmittedFileName();
        System.out.println("上传的文件名:"+fileName);
        resp.getWriter().write("上传的文件名:"+fileName);

        //得到文件存放路径
        String filePath=req.getServletContext().getRealPath("/");
        System.out.println("文件存放路径:"+filePath);
        resp.getWriter().write("文件存放路径："+filePath);
        //上传文件到指定目录
        part.write(filePath+"/"+fileName);
    }
}
