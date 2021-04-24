package com.guohuaijiang.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接的实现
 * 
 * @author 小江
 *
 */
public class JDBCUtil {

	private static String url = "jdbc:mysql://localhost:3306/123456";
	private static String username = "root";
	private static String password = "123456";
	private static String driverName = "com.mysql.jdbc.Driver";

	public Connection getConnection() throws Exception {
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public void closeCon(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}
	
	/**
	 * 测试是否连接成功
	 * @param args
	 */
	public static void main(String[] args) {
		JDBCUtil jdbc=new JDBCUtil();
		try {
			jdbc.getConnection();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			System.out.println("数据库连接失败！");
		}
	}
}
