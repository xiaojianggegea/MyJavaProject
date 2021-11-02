package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.constants.EstoreConstants;
import com.briup.service.IOrderFormService;
import com.briup.service.impl.OrderFormServiceImpl;

@WebServlet("/user/showOrderListServlet")
public class ShowOrderListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IOrderFormService orderFormService = new OrderFormServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY);
		
		List<OrderForm> list = orderFormService.findOrderFormByCustomerId(customer.getId());
		
		req.setAttribute("orderList", list);
		
		// 跳转到orderlist.jsp页面
		String path = "/WEB-INF/orderlist.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
