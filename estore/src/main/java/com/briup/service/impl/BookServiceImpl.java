package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.dao.BookMapper;
import com.briup.service.IBookService;
import com.briup.util.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService {
	
	private BookMapper bookMapper;
	
	@Override
	public List<Book> findAllBooks() {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
//		Map<Integer,Book> map = sqlSession.selectMap("namespace.id", "id");
		
		bookMapper = sqlSession.getMapper(BookMapper.class);
		
		List<Book> list = bookMapper.findAllBooks();
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public Book findBookById(Integer id) {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		bookMapper = sqlSession.getMapper(BookMapper.class);
		
		Book book = bookMapper.findBookById(id);
		
		sqlSession.close();
		
		return book;
	}

}
