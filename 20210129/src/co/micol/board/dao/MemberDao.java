package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.board.common.DAO;
import co.micol.board.vo.MemberVo;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> selectList(){
		ArrayList<MemberVo> list = new ArrayList<>();
		String sql = "SELECT * FROM member ORDER BY mAuth";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setmId(rs.getString("mid"));
				vo.setmName(rs.getString("mname"));
				vo.setmPassword(rs.getString("mpassword"));
				vo.setmAuth(rs.getString("mauth"));
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
	
	public MemberVo select(MemberVo vo) {
		String sql = "SELECT * FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmId(rs.getString("mid"));
				vo.setmName(rs.getString("mname"));
				vo.setmPassword(rs.getString("mpassword"));
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(MemberVo vo) {
		int n = 0;
		String sql = "INSERT INTO member(mid, mname, mpassword) VALUES(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(MemberVo vo) {
		int n = 0;
		String sql = "UPDATE member SET mpassword = ?, mname = ? WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmPassword());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(MemberVo vo) {
		int n = 0;
		String sql = "DELETE FROM member WHERE mid=?";
		try {
			psmt =  conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
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
	
	
}
