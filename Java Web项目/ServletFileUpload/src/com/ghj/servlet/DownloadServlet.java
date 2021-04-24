package com.ghj.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("文件下载......");

        //设置请求编码格式
        req.setCharacterEncoding("UTF-8");

        //获取参数的到下载文件名
        String fileName=req.getParameter("fileName");
        if(fileName ==null || "".equals(fileName.trim())){
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("请输入要下载的文件名！");
            resp.getWriter().close();
            return;
        }

        //得到图片存放历经
        String path=req.getServletContext().getRealPath("/download/");

        //通过路径得到file对象、
        File file=new File(path+fileName);

        //判断文件对象是否存在并是一个标准文件
        if (file.exists() && file.isFile()){
            //设置响应类型（浏览器无法使用某种方式或激活某个程序来处理的MIME类型）
            resp.setContentType("application/x-msdownload");
            //设置响应头
            resp.setHeader("Content-Disposition","attachment;filename="+fileName);
            //得到file文件输入流
            InputStream in=new FileInputStream(file);
            //得到字节输出流
            ServletOutputStream out=resp.getOutputStream();
            //定义byte数组
            byte[] bytes=new byte[1024];
            //定义长度
            int len=0;
            //循环输出
            while ((len=in.read(bytes)) !=-1){
               //输出
               out.write(bytes,0,len);
            }
            //关闭资源
            out.close();
            in.close();

        }else {
            resp.getWriter().write("文件不存在，请重试！");
            resp.getWriter().close();
        }
    }
}
