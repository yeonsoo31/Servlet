package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	Connection con; 
	PreparedStatement pstmt; 
	ResultSet rs; 
	private static DAO dao;
	public static DAO getInstance() {
		if(dao==null) {
			dao = new DAO();
		}
		return dao;
	} 
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int insertDB(String name) {
		String sql = "INSERT INTO NAMETEST NAME VALUES (?)";
		int result = 0;
		try { 
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<String> selectDB() {
		String sql = "SELECT * FROM NAMETEST";
		List<String> resultList = new ArrayList<String>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				resultList.add(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return resultList;
	}
	
}