package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.constants.EstoreConstants;
import com.briup.service.IOrderFormService;
import com.briup.service.IShopAddressService;
import com.briup.service.impl.OrderFormServiceImpl;
import com.briup.service.impl.ShopAddressServiceImpl;

@WebServlet("/user/orderServlet")
public class OrderServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private IShopAddressService addressService = new ShopAddressServiceImpl();
	
	private IOrderFormService orderFormService = new OrderFormServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String addressIdStr = req.getParameter("addressId");
		
		String receiveName = req.getParameter("receiveName");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		
		Customer customer = (Customer) req.getSession().getAttribute(EstoreConstants.USER_LOGIN_SESSION_KEY);
		
		// 地址
		ShopAddress shopAddress = null;
		
		if(addressIdStr!=null) {
			int addressId = Integer.valueOf(addressIdStr);
			shopAddress = addressService.findAddressById(addressId);
		}
		else {
			shopAddress = new ShopAddress();
			shopAddress.setReceiveName(receiveName);
			shopAddress.setAddress(address);
			shopAddress.setPhone(phone);
			shopAddress.setCustomer(customer);
			addressService.saveAddress(shopAddress);
		}
		
		ShopCar shopCar = (ShopCar) req.getSession().getAttribute("ShopCar");
		// 订单和订单项
		OrderForm order = new OrderForm();
		order.setCost(shopCar.getCost());
		order.setOrderdate(new Date());
		order.setCustomer(customer);
		order.setShopAddress(shopAddress);
		order.setOrderLines(shopCar.getOrderLines());
		
		orderFormService.saveOrderForm(order);
		
		
		String path = "/user/showOrderListServlet";
		resp.sendRedirect(req.getContextPath() + path);
		
		
		
		
	}
	
}
