package com.guohuaijiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guohuaijiang.model.Car;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.StringUtil;

/**
 * 车辆信息管理数据库操作的实现
 * 
 * @author 小江
 *
 */
public class CarDao {
	public int add(Connection conn, Car car) throws Exception {
		String sql = "insert into carinformation values(null,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, car.getCarClientName());
		pstmt.setString(2, car.getCarBrand());
		pstmt.setString(3, car.getCarNumber());
		pstmt.setString(4, car.getCarPhoneNumber());
		return pstmt.executeUpdate();
	}

	/**
	 * 车辆基本信息查询
	 * 
	 * @param conn
	 * @param car
	 * @return
	 * @throws Exception
	 */

	public ResultSet list(Connection conn, Car car) throws Exception {
		StringBuffer sb = new StringBuffer("select * from carinformation");
		
		if (StringUtil.isNotEmpty(car.getCarNumber())) {
			sb.append(" and CarNumber like '%" + car.getCarNumber() + "%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * 删除汽车基本信息
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn, String id) throws Exception {
		String sql = "delete from carinformation where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * 修改汽车基本信息
	 * @param conn
	 * @param car
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn, Car car) throws Exception {
		String sql = "update carinformation set CarClientName=?,CarBrand=?,CarNumber=?,CarPhoneNumber=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, car.getCarClientName());
		pstmt.setString(2, car.getCarBrand());
		pstmt.setString(3, car.getCarNumber());
		pstmt.setString(4, car.getCarPhoneNumber());
		pstmt.setInt(5, car.getId());
		return pstmt.executeUpdate();

	}
}
