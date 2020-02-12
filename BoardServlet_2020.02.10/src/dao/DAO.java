package dao;

import static db.JdbcUtil.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.DAO;
import dto.BoardDTO;


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
	
	
	public int boardPost(BoardDTO boardDTO) {
		String sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL,?,?,?,?,SYSDATE, 0)";
		int postResult = 0;
		try { 
			pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, boardDTO.getbWriter());
			pstmt.setString(2, boardDTO.getbPassword());
			pstmt.setString(3, boardDTO.getbTitle());
			pstmt.setString(4, boardDTO.getbContents());
			postResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return postResult;
	}
	
	
	
	public List<BoardDTO> boardList() {
		System.out.println("DAO boardList 메소드 호출");
		String sql = "SELECT * FROM BOARD";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO boardDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setbNumber(rs.getInt("BNUMBER"));
				boardDTO.setbWriter(rs.getString("BWRITER"));
				boardDTO.setbPassword(rs.getString("BPASSWORD"));
				boardDTO.setbTitle(rs.getString("BTITLE"));
				boardDTO.setbContents(rs.getString("BCONTENTS"));
				boardDTO.setbDate(rs.getDate("BDATE"));
				boardDTO.setbHits(rs.getInt("BHITS"));
				boardList.add(boardDTO);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("boardList 오류!!" + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	public BoardDTO boardView(String bWriter) {
		BoardDTO boardView = new BoardDTO();
		String sql = "SELECT BNUMBER, BWRITER, BDATE, BTITLE, BHITS, BCONTENTS FROM BOARD WHERE BWRITER = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bWriter);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardView.setbNumber(rs.getInt("BNUMBER"));
				boardView.setbWriter(rs.getString("BWRITER"));
				boardView.setbDate(rs.getDate("BDATE"));
				boardView.setbTitle(rs.getString("BTITLE"));
				boardView.setbHits(rs.getInt("BHITS"));
				boardView.setbContents(rs.getString("BCONTENTS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardView;
	}
	public int boardbHits(int bNumber) {
		String sql = "UPDATE BOARD SET BHITS=BHITS+1 WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,  bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public BoardDTO boardView(int bNumber) {
		String sql = "SELECT * FROM BOARD WHERE BNUMBER=?";
		BoardDTO boardDTO = new BoardDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDTO.setbNumber(rs.getInt("BNUMBER"));
				boardDTO.setbWriter(rs.getString("BWRITER"));
				boardDTO.setbPassword(rs.getString("BPASSWORD"));
				boardDTO.setbTitle(rs.getString("BTITLE"));
				boardDTO.setbContents(rs.getString("BCONTENTS"));
				boardDTO.setbDate(rs.getDate("BDATE"));
				boardDTO.setbHits(rs.getInt("BHITS"));
				boardDTO.setbFile(rs.getString("BFILE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardDTO;
	}
	
	
	public int boardModify(BoardDTO boardModify) {
		String sql = "UPDATE BOARD SET BTITLE=?, BWRITER=?, BCONTENTS=? WHERE BNUMBER=?";
		int boardModifyResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardModify.getbTitle());
			pstmt.setString(2, boardModify.getbWriter());
			pstmt.setString(3, boardModify.getbContents());
			pstmt.setInt(4, boardModify.getbNumber());
			boardModifyResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardModifyResult;
	}
	
	
	public int boardDelete(int bNumber) {
		String sql = "DELETE FROM BOARD WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int boardDeleteProcess(int bNumber) {
		String sql = "DELETE FROM BOARD WHERE BNUMBER=?";
		int boardDeleteProcessResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			boardDeleteProcessResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardDeleteProcessResult;
	}
	
	
	public int boardPostFile(BoardDTO boardDTO) {
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?,?,?,?,SYSDATE, 0, ?)";
		int postResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getbWriter());
			pstmt.setString(2, boardDTO.getbPassword());
			pstmt.setString(3, boardDTO.getbTitle());
			pstmt.setString(4, boardDTO.getbContents());
			pstmt.setString(5, boardDTO.getbFile());
			postResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return postResult;
	}

	
	
}
