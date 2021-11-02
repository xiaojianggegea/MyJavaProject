package com.briup.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Book;
import com.briup.util.MyBatisSqlSessionFactory;

public class BookMapperTest {

	@Test
	public void test_findAllBooks() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			List<Book> list = mapper.findAllBooks();
			list.forEach(System.out::println);
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
	@Test
	public void test_findBookById() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MyBatisSqlSessionFactory.openSession();
			BookMapper mapper = sqlSession.getMapper(BookMapper.class);
			
			Book book = mapper.findBookById(1);
			
			System.out.println(book);
			
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}

}
