package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.board.common.DAO;
import co.micol.board.vo.BoardVo;

public class BoardDao extends DAO{ //상속 해줘야 DB에 접속함
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardVo> selectList(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo vo;
		String sql = "SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVo();
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BoardVo select(BoardVo vo) {
		String sql = "SELECT * FROM board WHERE bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbName(rs.getString("bname"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				vo.setbGroup(rs.getInt("bgroup"));
				vo.setbStep(rs.getInt("bstep"));
				vo.setbIndent(rs.getInt("bindent"));
			}
			System.out.println(vo.toString());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BoardVo vo) {
		int n = 0;
		String sql = "INSERT INTO board VALUES(bidseq.NEXTVAL,?,?,?,SYSDATE,0,0,0,0)"; //?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
//			psmt.setInt(4, vo.getbHit());
//			psmt.setInt(5, vo.getbGroup());
//			psmt.setInt(6, vo.getbStep());
//			psmt.setInt(7, vo.getbIndent());
			n = psmt.executeUpdate();
			System.out.println(n+"건 입력");
			System.out.println(vo.toString());
		}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		return n;
	}
	
	public int delete(BoardVo vo) {
		int n = 0;
		String sql = "DELETE FROM board WHERE bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n+"건 삭제");
		}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		return n;
	}
	
	public int update(BoardVo vo) {
		int n = 0;
		String sql = "UPDATE board SET bcontent = ? WHERE bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
			System.out.println(n+"건 업데이트");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
