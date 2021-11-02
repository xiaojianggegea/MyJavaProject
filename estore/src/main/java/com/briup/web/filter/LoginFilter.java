package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.constants.EstoreConstants;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebFilter("/user/*")
public class LoginFilter implements Filter{
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object customer = req.getSession().getAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY);
		
		boolean flag = false;
		
		// 1 session中有customer 说明已经登录
		if(customer!=null) {
			flag = true;
		}
		else if(customer == null) {
			Cookie[] cookies = req.getCookies();
			
			if(cookies != null) {
				for(Cookie c:cookies) {
					if(EstoreConstants.AUTO_LOGIN_COOKIE_NAME.equals(c.getName())) {
						// value就是自动登录的用户名
						String value = c.getValue();
						Customer cus = customerService.findCustomerByName(value);
						if(cus!=null) {
							req.getSession().setAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY, cus);
							// 2 customer是null 但是有cookie 并且cookie的名字autologin ，说明需要自动登录
							flag = true;
							break;//退出循环
						}
					}
				}
			}
		}
		
		if(flag) {
			chain.doFilter(request, response);
		}
		else {
			req.getSession().setAttribute("msg", "请先登录");
			String path = "/login.jsp";
			resp.sendRedirect(req.getContextPath()+ path);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
