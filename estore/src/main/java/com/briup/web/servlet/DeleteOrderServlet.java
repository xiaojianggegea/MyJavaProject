package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.service.IOrderFormService;
import com.briup.service.impl.OrderFormServiceImpl;

@WebServlet("/user/deleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IOrderFormService orderFormService = new OrderFormServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int orderId = Integer.valueOf(req.getParameter("id"));
		
		orderFormService.deleteOrderFormById(orderId);
		
		String path = "/user/showOrderListServlet";
		resp.sendRedirect(req.getContextPath() + path);
	}
	
}
