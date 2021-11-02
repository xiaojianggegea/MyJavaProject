package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.briup.bean.Customer;
import com.briup.constants.EstoreConstants;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

//@WebFilter("/user/*")
public class AutoLoginFilter implements Filter{
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(req.getSession().getAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY) != null) {
			chain.doFilter(request, response);
		}
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {
			for(Cookie c:cookies) {
				if(EstoreConstants.AUTO_LOGIN_COOKIE_NAME.equals(c.getName())) {
					// value就是自动登录的用户名
					String value = c.getValue();
					Customer customer = customerService.findCustomerByName(value);
					if(customer!=null) {
						req.getSession().setAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY, customer);
						break;//退出循环
					}
				}
			}
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
