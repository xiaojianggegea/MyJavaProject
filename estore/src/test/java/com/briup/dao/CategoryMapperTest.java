package com.briup.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Category;
import com.briup.util.MyBatisSqlSessionFactory;

public class CategoryMapperTest {

	@Test
	public void test_findAllCategorys() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MyBatisSqlSessionFactory.openSession();
			
			CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
			
			List<Category> list = mapper.findAllCategorys();
			
			list.forEach(System.out::println);
			
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
	}

}
