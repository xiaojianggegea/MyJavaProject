package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShopCar;

@WebServlet("/user/deleteOrderLineOfShopCarServlet")
public class DeleteOrderLineOfShopCarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookId = Integer.valueOf(req.getParameter("bookId"));
		ShopCar shopCar = (ShopCar) req.getSession().getAttribute("ShopCar");
		shopCar.removeOrderLine(bookId);
		
		String path = "/user/showShopCarServet";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
