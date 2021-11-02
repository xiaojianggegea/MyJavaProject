package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.ShopAddress;
import com.briup.constants.EstoreConstants;
import com.briup.service.IShopAddressService;
import com.briup.service.impl.ShopAddressServiceImpl;

@WebServlet("/user/confirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private IShopAddressService addressService = new ShopAddressServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY);
		
		List<ShopAddress> list = addressService.findAddressByCustomerId(customer.getId());
		
		
		req.setAttribute("shopAddressList", list);
		
		String path = "/WEB-INF/confirm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
