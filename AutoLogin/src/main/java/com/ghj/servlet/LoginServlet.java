package com.ghj.servlet;

import com.ghj.service.impl.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: AutoLogin
 * @description: 登录控制
 * @author: 小江
 * @create: 2021-10-15 16:31
 **/
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String auto = req.getParameter("auto");
        if (new LoginServiceImpl().login(username,password)){
            req.getSession().setAttribute("uname",username);
            if (auto ==null) {
                Cookie cookie = new Cookie("auto", null);
                cookie.setMaxAge(60*60*24*3);
                cookie.setPath(req.getContextPath()+"/");
                resp.addCookie(cookie);
            }else {
                Cookie cookie  = new Cookie("auto",username+"_"+password);
                cookie.setMaxAge(60*60*24);
                cookie.setPath(req.getContextPath()+"/");
                resp.addCookie(cookie);
            }
            resp.sendRedirect("/index.html");
        }else{
            resp.sendRedirect("/login.html");
        }
    }
}
