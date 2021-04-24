package com.ghj.servlet;import javax.servlet.annotation.WebServlet;import javax.servlet.http.Cookie;import javax.servlet.http.HttpServlet;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;import java.io.IOException;import java.net.URLDecoder;import java.net.URLEncoder;/** * Cookie使用注意事项 *     1、Cookie只在当前浏览器中有效（不夸浏览器与电脑） *     2、Cookie不能存在中文 *     3、若要存中文则需要URLEncoder.encode()方法进行编码，在获取时通过URLDecoder.decode()方法解码 *     4、Cookie出现重名对象会覆盖 *     5、Cookie的存储数量有限，不同浏览器上限不同 */@WebServlet("/cookie04")public class Servlet04CookiePrecautions extends HttpServlet {    @Override    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {        /*Cookie存中文*/        String name="姓名";        String value="张三";        //将中文通过URLEncoder进行编码        name= URLEncoder.encode(name);        value=URLEncoder.encode(value);        //创建Cookie对象        Cookie cookie=new Cookie(name,value);        //发送Cookie        resp.addCookie(cookie);        //获取Cookie时，通过URLDecoder.decode()进行解码        Cookie[] cookies=req.getCookies();        //判断cookie是否为空        if(cookies !=null && cookies.length>0){            //遍历数组            for(Cookie cook:cookies){                //解码                resp.setContentType("text/html,charset=utf-8");                System.out.println("名称："+URLDecoder.decode(cook.getName())+",值："+URLDecoder.decode(cook.getValue()));                resp.getWriter().write("名称："+URLDecoder.decode(cook.getName())+",值："+URLDecoder.decode(cook.getValue()));            }        }        //将原来的已有Cookie对象重新覆盖        Cookie cookie1=new Cookie("name","王麻子");        resp.addCookie(cookie1);        resp.getWriter().write("name:"+name+"  "+"value:"+value);    }}