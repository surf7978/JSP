package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.memberVO;
import co.micol.common.DAO;

public class memberDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

//전체조회	
	public ArrayList<memberVO> selectList() {
		ArrayList<memberVO> list = new ArrayList<memberVO>();
		memberVO vo;
		String sql = "SELECT * FROM member99";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new memberVO();
				vo.setMemberId(rs.getString("memberId"));
				vo.setMemberPassword(rs.getString("memberPassword"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberAuth(rs.getString("memberAuth"));
				vo.setMemberSiAddress(rs.getString("memberSiAddress"));
				vo.setMemberGuAddress(rs.getString("memberGuAddress"));
				vo.setMemberPhoneNumber(rs.getString("memberPhoneNumber"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
//
////관리자 조회
//	public memberVO adminSelect(memberVO vo) {
//		String sql = "SELECT * FROM member WHERE mid=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getmId());
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				vo.setmId(rs.getString("mId"));
//				vo.setmName(rs.getString("mName"));
//				vo.setmPassword(rs.getString("mPassword"));
//				vo.setmBirth(rs.getString("mBirth"));
//				vo.setmAuth(rs.getString("mAuth"));
//				vo.setmAddress(rs.getString("mAddress"));
//				vo.setmNumber(rs.getString("mNumber"));
//			}
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//		return vo;
//	}

//// 관리자-수정
//	public int updateMember(memberVO vo) { // 아이디, 이름, 생년월일 제외 / 권한은 관리자만 수정
//		String sql = "UPDATE member99 SET"//
//				+ " memberPassword=?"//
//				+ ", memberName=?"//
//				+ ", memberSiAddress=?"//
//				+ ", memberGuAddress=?"//
//				+ ", memberPhoneNumber=?"//
//				+ " WHERE memberid=?";
//		int n = 0;
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getMemberPassword());
//			psmt.setString(2, vo.getMemberName());
//			psmt.setString(3, vo.getMemberSiAddress());
//			psmt.setString(4, vo.getMemberGuAddress());
//			psmt.setString(5, vo.getMemberPhoneNumber());
//			psmt.setString(6, vo.getMemberId());
//			n = psmt.executeUpdate();
//			System.out.println(n + "건 업데이트.");
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//
//		return n;
//	}

	public memberVO login(memberVO vo) {

		String sql = "SELECT * FROM member99 WHERE memberId=? and memberPassword = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberId(rs.getString("memberId"));
				vo.setMemberPassword(rs.getString("memberPassword"));
				vo.setMemberName(rs.getString("memberName"));
				vo.setMemberAuth(rs.getString("memberAuth"));
				vo.setMemberSiAddress(rs.getString("memberSiAddress"));
				vo.setMemberGuAddress(rs.getString("memberGuAddress"));
				vo.setMemberPhoneNumber(rs.getString("memberPhoneNumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

////등록
//	public int insert(memberVO vo) { // 권한 제외
//		String sql = "INSERT INTO member (mid,mpassword, mname, mbirth, mnumber, mAddress) VALUES (?,?,?,?,?,?)";
//		int n = 0;
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getmId());
//			psmt.setString(2, vo.getmPassword());
//			psmt.setString(3, vo.getmName());
//			psmt.setString(4, vo.getmBirth());
//			psmt.setString(5, vo.getmNumber());
//			psmt.setString(6, vo.getmAddress());
//			n = psmt.executeUpdate();
//			System.out.println(n + "건 등록.");
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//
//		return n;
//	}
//
//수정
	public void updateProfile(memberVO vo) { 
		String sql = "UPDATE member99 SET memberPassword=?, memberName=?"
				+ ", memberPhoneNumber=?, memberSiAddress=?, memberGuAddress=?"//
				+ " WHERE memberId=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPhoneNumber());
			psmt.setString(4, vo.getMemberSiAddress());
			psmt.setString(5, vo.getMemberGuAddress());
			psmt.setString(6, vo.getMemberId());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

//삭제
	public void deleteMember(memberVO vo) {
		String sql = "DELETE FROM member99 WHERE memberid=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

////아이디채크
//	public int isIdCheck(String id) {
//		int cnt = 0;
//		String sql = "SELECT MID FROM MEMBER WHERE MID = ?";
//
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			rs = psmt.executeQuery();
//			if (rs.next()) {
//				cnt = 1;// 아이디 있으면 1
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("아이디 중복확인 실패");
//		} finally {
//			close();
//		}
//		return cnt;
//	}

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
