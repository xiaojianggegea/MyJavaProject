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

@WebServlet("/user/addShopCarServlet")
public class AddShopCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookId = Integer.valueOf(req.getParameter("bookId"));
		int num = Integer.valueOf(req.getParameter("num"));
		
		@SuppressWarnings("unchecked")
		Map<Integer,Book> map = (Map<Integer, Book>) req.getServletContext().getAttribute("bookMap");
		
		Book book = map.get(bookId);
		
		ShopCar shopCat = (ShopCar) req.getSession().getAttribute("ShopCar");
		
		shopCat.add(book, num);
		
		String msg = "添加购物车成功！请继续购买";
		String path = "/user/indexServlet";
		
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath() + path);
	}
	
}
