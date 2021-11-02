package com.briup.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.service.IBookService;
import com.briup.service.ICategoryService;
import com.briup.service.impl.BookServiceImpl;
import com.briup.service.impl.CategoryServiceImpl;

@WebListener
public class ApplicationInit implements ServletContextListener{
	
	private ICategoryService categoryService = new CategoryServiceImpl();
	
	private IBookService bookService = new BookServiceImpl();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		
		List<Category> categorys = categoryService.findAllCategorys();
		application.setAttribute("categorys", categorys);
		
		List<Book> books = bookService.findAllBooks();
		
		application.setAttribute("books", books);
		
		final Map<Integer,Book> map = new HashMap<>();
		books.forEach(book->map.put(book.getId(), book));
		application.setAttribute("bookMap", map);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
