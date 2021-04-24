package com.guohuaijiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guohuaijiang.model.CarMaintain;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.StringUtil;

/**
 * ����ά����Ϣ���ݿ����ʵ��
 * 
 * @author С��
 *
 */
public class CarMaintainDao {

	/**
	 * ά����Ϣ��¼��
	 * 
	 * @param conn
	 * @param carMaintain
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn, CarMaintain carMaintain) throws Exception {
		String sql = "insert into carmaintain values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, carMaintain.getCarNumber());
		pstmt.setString(2, carMaintain.getPartsName());
		pstmt.setString(3, carMaintain.getPartsQuantity());
		pstmt.setString(4, carMaintain.getRepairNumber());
		pstmt.setString(5, carMaintain.getRepairWhen());
		pstmt.setString(6, carMaintain.getRepairCost());
		return pstmt.executeUpdate();
	}

	/**
	 * ά����Ϣ�Ĳ�ѯ
	 * 
	 * @param conn
	 * @param carMaintain
	 * @return
	 * @throws Exception
	 */

	public ResultSet list(Connection conn, CarMaintain carMaintain) throws Exception {
		StringBuffer sb = new StringBuffer("select * from carmaintain");
		if (StringUtil.isNotEmpty(carMaintain.getCarNumber())) {
			sb.append(" and CarNumber like '%" + carMaintain.getCarNumber() + "%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}

	/**
	 * ɾ������ά����Ϣ
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn, String id) throws Exception {
		String sql = "delete from carmaintain where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * �޸ĳ���ά����Ϣ
	 * @param conn
	 * @param carMaintain
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn, CarMaintain carMaintain) throws Exception {
		String sql = "update carmaintain set CarNumber=?,PartsName=?,PartsQuantity=?,RepairNumber=?,RepairWhen=?,RepairCost=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, carMaintain.getCarNumber());
		pstmt.setString(2, carMaintain.getPartsName());
		pstmt.setString(3, carMaintain.getPartsQuantity());
		pstmt.setString(4, carMaintain.getRepairNumber());
		pstmt.setString(5, carMaintain.getRepairWhen());
		pstmt.setString(6, carMaintain.getRepairCost());
		pstmt.setInt(7, carMaintain.getId());
		return pstmt.executeUpdate();

	}
}
