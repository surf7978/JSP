package co.micol.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.common.DAO;
import co.micol.vo.MemberVo;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public MemberVo login(MemberVo vo) {
		String sql = "SELECT * FROM member1 WHERE memberid = ? AND memberpassword = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberTel(rs.getString("membertel"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
			System.out.println(vo.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public ArrayList<MemberVo> selectList(){
		ArrayList<MemberVo> list = new ArrayList<>();
		String sql = "SELECT * FROM member1 ORDER BY memberauth";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberTel(rs.getString("membertel"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public MemberVo select(MemberVo vo) {
		String sql = "SELECT * FROM member1 WHERE memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberTel(rs.getString("membertel"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(MemberVo vo) {
		int n = 0;
		String sql = "INSERT INTO member1"//
				+ "(memberid, membername, memberpassword, membertel, memberaddress)"//
				+ " VALUES(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());
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
		String sql = "UPDATE member1"//
				+ " SET membername = ?"//
				+ ", memberpassword = ?"//
				+ ", membertel = ?"//
				+ ", memberaddress = ?"//
				+ " WHERE memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberName());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberTel());
			psmt.setString(4, vo.getMemberAddress());
			psmt.setString(5, vo.getMemberId());
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
		String sql = "DELETE FROM member1 WHERE memberid=?";
		try {
			psmt =  conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
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
