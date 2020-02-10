package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

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
	public int signUpDB(MemberDTO member) {
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?)";
		int result = 0;
		try { 
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int loginDB(MemberDTO member) {
		String sql = "SELECT ID FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		int loginResult = 0;
		try { 
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setId(rs.getString("id"));
				loginResult = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginResult;
	}

	public List<MemberDTO> memberList(){
		String sql = "SELECT * FROM MEMBER";
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setBirth(rs.getString("birth"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}
	
	
	
	
	public MemberDTO memberView(String id) {
		MemberDTO member = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setName(rs.getString("NAME"));
				member.setBirth(rs.getString("BIRTH"));
				member.setGender(rs.getString("GENDER"));
				member.setEmail(rs.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return member;
	}
	
	
	
	public int memberModify(String id, String password, String email) {
		int result = 0;
		String sql = "UPDATE MEMBER SET PASSWORD=?, EMAIL=? WHERE ID=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return result;
	}
	public int memberDelete(String deleteId) {
		String sql = "DELETE FROM MEMBER WHERE ID = ?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deleteId);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteResult;
	}
	
	
	
	
	
}
