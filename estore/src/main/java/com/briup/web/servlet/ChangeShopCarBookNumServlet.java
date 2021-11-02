package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.bean.ShopCar;

@WebServlet("/user/changeShopCarBookNumServlet")
public class ChangeShopCarBookNumServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookId = Integer.valueOf(req.getParameter("bookId"));
		int num = Integer.valueOf(req.getParameter("num"));
		
		@SuppressWarnings("unchecked")
		Map<Integer,Book> map = (Map<Integer, Book>) req.getServletContext().getAttribute("bookMap");
		Book book = map.get(bookId);
		
		ShopCar shopCar = (ShopCar) req.getSession().getAttribute("ShopCar");
		
		shopCar.removeOrderLine(bookId);
		shopCar.add(book, num);
		
		String path = "/user/showShopCarServet";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
