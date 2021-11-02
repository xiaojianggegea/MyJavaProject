package com.briup.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;

@WebServlet("/user/viewBookServlet")
public class ViewBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String str = req.getParameter("id");
		int id = -1;
		if(str!=null) {
			id = Integer.valueOf(str);
		}
		
		@SuppressWarnings("unchecked")
		Map<Integer,Book> map = (Map<Integer, Book>) req.getServletContext().getAttribute("bookMap");
		Book book = map.get(id);
		
		req.setAttribute("book", book);
		
		String path = "/WEB-INF/viewBook.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
}
