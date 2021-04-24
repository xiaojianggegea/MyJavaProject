package com.guohuaijiang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guohuaijiang.model.CarMaintain;
import com.guohuaijiang.model.Client;
import com.guohuaijiang.model.Parts;
import com.guohuaijiang.util.StringUtil;

/**
 * 采购管理数据库操作的实现
 * 
 * @author 小江
 *
 */
public class PartsDao {
	public int add(Connection conn, Parts parts) throws Exception {
		String sql = "insert into partsinformation values(null,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, parts.getPartsName());
		pstmt.setString(2, parts.getPartsNumber());
		pstmt.setString(3, parts.getPartsPrice());
		return pstmt.executeUpdate();
	}

	/**
	 * 查看零件库存
	 * 
	 * @param conn
	 * @param parts
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection conn, Parts parts) throws Exception {
		StringBuffer sb = new StringBuffer("select * from partsinformation");
		if (StringUtil.isNotEmpty(parts.getPartsName())) {
			sb.append(" and PartName like '%" + parts.getPartsName() + "%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}
	/**
	 * 删除零件信息
	 * 
	 * @param conn
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection conn, String id) throws Exception {
		String sql = "delete from partsinformation where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 *  修改零件信息
	 * @param conn
	 * @param parts
	 * @return
	 * @throws Exception
	 */
	public int update(Connection conn, Parts parts) throws Exception {
		String sql = "update partsinformation set PartsName=?,PartsNumber=?,PartsPrice=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, parts.getPartsName());
		pstmt.setString(2, parts.getPartsNumber());
		pstmt.setString(3, parts.getPartsPrice());
		pstmt.setInt(4, parts.getId());
		return pstmt.executeUpdate();

	}
}
