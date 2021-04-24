package com.guohuaijiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guohuaijiang.model.Client;
import com.guohuaijiang.util.StringUtil;

public class ClientDao {
	/**
	 * �ͻ���Ϣ�������ݿ������ʵ��
	 * 
	 * @param conn
	 * @param client
	 * @return
	 * @throws Exception
	 */

	public int add(Connection conn, Client client) throws Exception {
		String sql = "insert into clientinformation values(null,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, client.getClientName());
		pstmt.setString(2, client.getGender());
		pstmt.setString(3, client.getIDNumber());
		pstmt.setString(4, client.getPhoneNumber());
		pstmt.setString(5, client.getHomeAddress());
		return pstmt.executeUpdate();
	}

	/**
	 * �ͻ���Ϣ��ѯ
	 * 
	 * @param conn
	 * @param client
	 * @return
	 * @throws Exception
	 */

	public ResultSet list(Connection conn, Client client) throws Exception {
		StringBuffer sb = new StringBuffer("select * from clientinformation");
		if (StringUtil.isNotEmpty(client.getIDNumber())) {
			sb.append(" and IDNumber like '%" + client.getIDNumber() + "%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}

	/**
	 * ɾ���ͻ���Ϣ
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn, String id) throws Exception {
		String sql = "delete from clientinformation where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * �޸Ŀͻ���Ϣ
	 * 
	 * @param conn
	 * @param client
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn, Client client) throws Exception {
		String sql = "update clientinformation set clientName=?,Gender=?,IDNumber=?,PhoneNumber=?,HomeAddress=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, client.getClientName());
		pstmt.setString(2, client.getGender());
		pstmt.setString(3, client.getIDNumber());
		pstmt.setString(4, client.getPhoneNumber());
		pstmt.setString(5, client.getHomeAddress());
		pstmt.setInt(6, client.getId());
		return pstmt.executeUpdate();

	}
}
