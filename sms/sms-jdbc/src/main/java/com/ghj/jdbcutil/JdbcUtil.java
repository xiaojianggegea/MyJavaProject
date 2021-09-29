package com.ghj.jdbcutil;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
	private static DataSource dataSource;
	static {
		Properties p = new Properties();
		InputStream inStream = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			p.load(inStream);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// 关闭资源
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void close(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// DDL、DML
	public static int executeDML(String sql) {
		Connection conn = null;
		Statement stmt = null;
		int rows = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rows = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt, conn);
		}
		return rows;
	}

	// DQL
	//查询出list集合
	public static <T> List<T> executeDQLForList(String sql, Function<ResultSet,T> function) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		T obj = null;
		List<T> list = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				obj = function.apply(rs);
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, conn);
		}
		return list;
	}

	// 查询对象
	public static <T> T executeDQLForObject(String sql, Function<ResultSet, T> function) {
		List<T> list = executeDQLForList(sql, function);
		if (list.size() > 0) {
			throw new RuntimeException("只能查询一条数据!" + list.size());
		}
		return list.size() == 1 ? list.get(0) : null;
	}

	// 查询指定类型
	public static <T> List<T> executeDQLForList(String sql, Class<T> c) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		T obj = null;
		List<T> list = new ArrayList<>();
		// key属性名
		// value属性类型
		Map<String, String> map = pareClass(c);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				obj = c.newInstance();
				// 取出rs中的值
				for (String attrName: map.keySet()) {
					String attrType = map.get(attrName);
					Object value = null;
					switch (attrType) {
					case "int":
						value = rs.getInt(attrName);
						break;
					case "String":
						value = rs.getString(attrName);
						break;
					case "long":
						value = rs.getInt(attrName);
						break;
					default:
						break;
					}
					setValue(obj,attrName,value);
				}
				// 字段名和属性名
				rs.getString("name");
				//
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt, conn);
		}
		return list;

	}
	/**
	 * 通过反射的方式将值放入到对象的属性中
	 * @param obj  目标对象
	 * @param attrName  指定属性名
	 * @param value    需要设置的值
	 * @throws Exception 异常
	 */
	private static void setValue(Object obj, String attrName, Object value) throws Exception {
		// TODO Auto-generated method stub
		Class<?> c = obj.getClass();
		Field file = c.getDeclaredField(attrName);
		file.setAccessible(true);
		file.set(obj,value);
	}

	/**
	 * 解析执行类型，获取内部属性名和属性类型
	 * @param c
	 * @return map
	 */
	private static Map<String, String> pareClass(Class<?> c) {
		Map<String, String> map = new HashMap<>();
		Field[] filFields = c.getDeclaredFields();
		for (Field field : filFields) {
			String fileName = field.getName();
			String fileType = field.getType().getSimpleName();
			map.put(fileName, fileType);
		}
		return map;
	}
}
