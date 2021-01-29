package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.board.common.DAO;
import co.micol.board.vo.BoardVo;
import co.micol.board.vo.ReplyVo;

public class BoardDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BoardVo> selectList(){
		ArrayList<BoardVo> list = new ArrayList<>();
		String sql = "SELECT * FROM board";
		BoardVo vo;
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
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				//여기에 조회수 올리는 거 추가하기
				hitCount(rs.getInt("bid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BoardVo vo) {
		int n = 0;
		String sql = "INSERT INTO board(bid, bname, btitle, bcontent, bdate, bhit) VALUES(bidseq.NEXTVAL,?,?,?,SYSDATE,0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbName());
			psmt.setString(2, vo.getbTitle());
			psmt.setString(3, vo.getbContent());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(BoardVo vo) {
		int n = 0;
		String sql = "UPDATE board SET bcontent = ? WHERE bid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbContent());
			psmt.setInt(2, vo.getbId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BoardVo vo) {
		int n = 0;
		String sql = "DELETE FROM board WHERE bid=?";
		try {
			psmt =  conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
	private void hitCount(int bid) {
		String sql = "UPDATE BOARD SET bhit = bhit+1 WHERE bid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bid);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ReplyVo> replySelect(ReplyVo vo){
		ArrayList<ReplyVo> replyList = new ArrayList<>();
		String sql = "SELECT * FROM reply WHERE bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBid());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new ReplyVo();
				vo.setBid(rs.getInt("bid"));
				vo.setRnum(rs.getInt("rnum"));
				vo.setRdate(rs.getDate("rdate"));
				vo.setSubject(rs.getString("subject"));
				replyList.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return replyList; 
	}
	
}
