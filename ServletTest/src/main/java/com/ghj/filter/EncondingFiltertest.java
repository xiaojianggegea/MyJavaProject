package com.ghj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: ServletTest
 * @description: 过滤器测试类
 * @author: 小江
 * @create: 2021-10-14 20:15
 **/
@WebFilter(value = "/servletTest",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class EncondingFiltertest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain;charset=UTF-8");
        chain.doFilter(request,response);
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI =  req.getRequestURI();
        System.out.println("当前过滤资源路径为："+requestURI);
    }

    @Override
    public void destroy() {

    }
}
