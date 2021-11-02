package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.constants.EstoreConstants;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private ICustomerService customerService = new CustomerServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String autologin = req.getParameter("autologin");
		
		String msg = "登录成功";
		String path = "/user/indexServlet";
		try {
			Customer customer = customerService.login(name, password);
			req.getSession().setAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY, customer);
			
			// 如果用户选择了自动登录
			if(autologin!=null) {
				Cookie c = new Cookie(EstoreConstants.AUTO_LOGIN_COOKIE_NAME,name);
				c.setMaxAge(EstoreConstants.AUTO_LOGIN_COOKIE_MAX_AGE);
				resp.addCookie(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "登录失败："+e.getMessage();
			path = "/login.jsp";
		}
		
//		req.setAttribute("msg", msg);
//		req.getRequestDispatcher(path).forward(req, resp);
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+path);
	}
	
}	
