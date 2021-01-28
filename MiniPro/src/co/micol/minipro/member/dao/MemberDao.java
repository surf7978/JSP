package co.micol.minipro.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;
import co.micol.minipro.member.service.MemberVo;

public class MemberDao extends DAO implements DbInterface<MemberVo> {
	
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public ArrayList<MemberVo> selectList() {
		// 회원전체정보 출력
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM member";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setmId(rs.getString("mid"));
				vo.setmId(rs.getString("mname"));
				vo.setmId(rs.getString("mauth"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVo select(MemberVo vo) {
		// 한명의 레코드를 찾아오는 메소드
		String sql = "SELECT * FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mname")); //여기는 DB의 파라미터명 적어야함
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVo vo) {
		// 회원가입 메소드
		String sql = "INSERT INTO member(mid, mname, mpassword) VALUES(?,?,?)";
		int n = 0;
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

	@Override
	public int update(MemberVo vo) {
		// 권한과 패스워드만 변경하는 메소드(이름,아이디는 변경X)
		// 지금은 변경하는 콜름이 적어서 이렇게 하지만 콜름수가 많아지면 
		// 걍 테이블 통째로 값 받아서 업데이트하는게 더 코딩하기 쉽다. 
		int n = 0;
		String sql = null;
		if(vo.getmPassword() != null) {
			sql = "UPDATE member SET mpassword = ? WHERE mid = ?";
		}else if(vo.getmAuth() != null) {
			sql = "UPDATE member SET mauth = ? WHERE mid = ?";
		}
		try {
			psmt = conn.prepareStatement(sql);
			if(vo.getmPassword() != null) {
				psmt.setString(1, vo.getmPassword());
				psmt.setString(2, vo.getmId());
			}else if(vo.getmAuth() != null) {
				psmt.setString(1, vo.getmAuth());
				psmt.setString(2, vo.getmId());
			}
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int delete(MemberVo vo) {
		// 회원 삭제 메소드
		int n = 0;
		String sql = "DELETE FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public boolean isIdCheck(String id) {
		//id 중복체크 메소드
		boolean bool = true; //기본 false
		String sql = "SELECT mid FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id); //입력한 id값 넣어서 select
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bool;
	}
	
	public MemberVo login(MemberVo vo) {
		// 로그인 메소드
		String sql = "SELECT * FROM member WHERE mid = ? AND mpassword = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mname")); //여기는 DB의 파라미터명 적어야함
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
