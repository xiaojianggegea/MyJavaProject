package com.ghj.jdbcutil;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ghj.entity.User;


public class JdbcUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String sql = "select * from t_user";
		JdbcUtil.executeDQLForList(sql, rs -> {
			User user = null;
			try {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("salary");
				user = new User(id,name,salary);
				System.out.println(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		});
	}

}
