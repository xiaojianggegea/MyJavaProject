package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;

@WebServlet("/user/indexServlet")
public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		
		@SuppressWarnings("unchecked")
		List<Book> list = (List<Book>) application.getAttribute("books");
		int size = list.size();
		
		Set<Integer> set = new HashSet<>();
		List<Book> hotBooks = new ArrayList<>();
		while(set.size()<3) {
			int index = (int)(Math.random()*size);
			set.add(index);
		}
		
		set.forEach(index -> hotBooks.add(list.get(index)));
		
		application.setAttribute("hotBooks", hotBooks);
		
		String path = "/WEB-INF/index.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
