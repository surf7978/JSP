package co.mini.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mini.board.common.DAO;
import co.mini.board.vo.MemberVo;

public class MemberDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	// 관리자용 멤버 조회 *****************
	
	public ArrayList<MemberVo> selectMember(){
		MemberVo vo = new MemberVo();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql = "SELECT * FROM MEMBER ORDER BY MEMBERAUTH";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberTel(rs.getString("membertel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	// 수정용 멤버셀렉트
	public ArrayList<MemberVo> selectMemberU(MemberVo vo){
		
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVo();
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberTel(rs.getString("membertel"));
				list.add(vo);
				System.out.println(rs.getString("memberaddress"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	

	// 관리자용 멤버 수정 *****************
	public int update(MemberVo vo) {
		int n = 0;

		String sql = "UPDATE MEMBER SET MEMBERNAME = ?, MEMBERTEL=?, MEMBERADDRESS=?, MEMBERAUTH=? WHERE MEMBERID=?";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberName());
			psmt.setString(2, vo.getMemberTel());
			psmt.setString(3, vo.getMemberAddress());
			psmt.setString(4, vo.getMemberAuth());
			psmt.setString(5, vo.getMemberId());

			n = psmt.executeUpdate();
			System.out.println("멤버정보수정 " + n + "건");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}
	
	

	// 관리자용 멤버 삭제 
	
	public int delete(MemberVo vo) {
		int n = 0;

		String sql = "DELETE FROM MEMBER WHERE MEMBERID=?";

		try {

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			n = psmt.executeUpdate();
			System.out.println("멤버정보수정 " + n + "건");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}
	
	//아이디 체크
	
	public boolean isIdCheck(String id) {

		boolean bool = false;
		String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				bool = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return bool;
	}
	

	// 회원가입 등록
	public int insert(MemberVo vo) {
		int n = 0;

		String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERNAME, MEMBERPASSWORD,MEMBERTEL, MEMBERADDRESS) VALUES(?,?,?,?,?)";

		try {
			System.out.println("가입 dao insert까지");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPassword());
			psmt.setString(4, vo.getMemberTel());
			psmt.setString(5, vo.getMemberAddress());

			n = psmt.executeUpdate();
			System.out.println("회원가입 등록 " + n + "건 등록");

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 로그인 기능

	public MemberVo login(MemberVo vo) {

		String sql = "SELECT MEMBERID, MEMBERNAME,MEMBERAUTH FROM MEMBER WHERE MEMBERID=? AND MEMBERPASSWORD=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVo();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
System.out.println("로그인member값넘기기성공");
			}

		} catch (SQLException e) {
System.out.println("로그인member값넘기기실패");
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;

	}

	
	//close
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
