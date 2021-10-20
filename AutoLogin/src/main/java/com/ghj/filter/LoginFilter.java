package com.ghj.filter;

import com.ghj.service.impl.LoginServiceImpl;
import com.ghj.uitl.CookieUitl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: AutoLogin
 * @description: 登录过滤器
 * @author: 小江
 * @create: 2021-10-15 17:06
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(req.getRequestURI().contains("login")) {
            //如果访问login
            chain.doFilter(req, resp);
        }else {
            String username = (String) req.getSession().getAttribute("uname");
            if(username==null) {
                String val = CookieUitl.getCookieValByKey("auto", req);
                if(val!= null&& !val.equals("")) {
                    String name = val.split("_")[0];
                    String pass = val.split("_")[1];
                    if(new LoginServiceImpl().login(name, pass)) {
                        req.getSession().setAttribute("uname", name);
                        chain.doFilter(req, resp);
                        return;
                    }else {
                        resp.sendRedirect("/login.html");
                    }
                }else {
                    resp.sendRedirect("/login.html");
                }
            }else {
                chain.doFilter(req, resp);
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
