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

	public void startSetting() {
		String sql1 = "create table member99(MemberId varchar2(10) not null primary key"//
				+ ", MemberPassword varchar2(20) not null, MemberName varchar2(20) not null"// 
				+ ", MemberAuth varchar2(10) default 'USER', MemberSiAddress varchar2(100) not null"//
				+ ", MemberGuAddress varchar2(100) not null, MemberPhoneNumber varchar2(20) not null)";
		String sql2 = "insert into member99"//
				+ "(MemberId, MemberPassword, MemberName, MemberAuth, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('admin','admin', '관리자', 'ADMIN', '대구시', '달서구', '010-1111-1111')";
		String sql3 = "insert into member99"//
				+ "(MemberId, MemberPassword, MemberName, MemberAuth, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('park','1234', '박', 'USER', '대구시', '서구', '010-2222-2222')";
		String sql4 = "insert into member99"//
				+ "(MemberId, MemberPassword, MemberName, MemberAuth, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('kim','1234', '김', 'USER', '대구시', '달성군', '010-3333-3333')";
		
		String sql5 = "create table board99(BoardTitle varchar2(100) not null"//
				+ ", BoardContent varchar2(1000) not null"//
				+ ", BoardDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"// 
				+ ", BoardView number default 0 not null, price number default 100 not null"
				+ ", ProductName varchar2(100) not null, MemberId varchar2(10) not null"
				+ ", MemberSiAddress varchar2(100) not null, MemberGuAddress varchar2(100) not null"
				+ ", MemberPhoneNumber varchar2(20) not null )";
		String sql6 = "insert into board99"//
				+ "(BoardTitle, BoardContent, ProductName, MemberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('폰팝니다','제곧내', '갤럭시s9', 'park', '대구시', '서구', '010-2222-2222')";
		
		String sql7 = "create table buy99"//
				+ "(BuyDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"//
				+ ", BuyMemberId varchar2(20) not null"// 
				+ ", BoardDate varchar2(20) not null"// 
				+ ", price number default 100 not null"
				+ ", ProductName varchar2(100) not null, MemberId varchar2(10) not null"
				+ ", MemberSiAddress varchar2(100) not null, MemberGuAddress varchar2(100) not null"
				+ ", MemberPhoneNumber varchar2(20) not null )";
		
		String sql8 = "create table product99"//
				+ "("//
				+ "ProductName varchar2(100) not null"
				+ ", Image varchar2(100)"
				+ ", Category1 varchar2(100) not null"
				+ ", Category2 varchar2(100) not null"
				+ " )";
		String sql9 = "insert into product99"//
				+ "(ProductName, Image, Category1, Category2 )"//
				+ " values('갤럭시s9','갤럭시s9.png', '전자기기', '스마트폰')";
		String sql10 = "insert into product99"//
				+ "(ProductName, Image, Category1, Category2 )"//
				+ " values('아이폰12','아이폰12.png', '전자기기', '스마트폰')";
		String sql11 = "insert into product99"//
				+ "(ProductName, Image, Category1, Category2 )"//
				+ " values('상의','상의.png', '의류', '상의')";
		String sql12 = "insert into product99"//
				+ "(ProductName, Image, Category1, Category2 )"//
				+ " values('하의','하의.png', '의류', '하의')";
		
		String sql13 = "create table comment99"//
				+ "("//
				+ "CommentContent varchar2(100) not null"//
				+ ", MemberId varchar2(10) not null"//
				+ ", BoardDate varchar2(20) not null"//
				+ ", CommentDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"
				+ " )";
		
		String sql14 = "create table sell99"//
				+ "("//
				+ "BuyMemberId varchar2(20) not null"//
				+ ", BuyDate varchar2(20) not null"//
				+ ", price number default 100 not null"//
				+ ", MemberId varchar2(10) not null"//
				+ ", tradeProcess varchar2(20) default 'NotComplete' not null"
				+ ", ProductName varchar2(100) not null"//
				+ " )";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql2);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql3);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql4);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql5);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql6);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql7);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql8);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql9);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql10);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql11);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql12);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql13);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql14);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void endSetting() {
		String sql1 ="drop table member99";
		String sql2 ="drop table board99";
		String sql3 ="drop table buy99";
		String sql4 ="drop table product99";
		String sql5 ="drop table comment99";
		String sql6 ="drop table sell99";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql2);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql3);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql4);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql5);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql6);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
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
//
//// 관리자-수정
//	public int adminUpdate(memberVO vo) { // 아이디, 이름, 생년월일 제외 / 권한은 관리자만 수정
//		String sql = "UPDATE member SET mpassword=?, mauth=?, mnumber=?, mAddress=? WHERE mid=?";
//		int n = 0;
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getmPassword());
//			psmt.setString(2, vo.getmAuth());
//			psmt.setString(3, vo.getmNumber());
//			psmt.setString(4, vo.getmAddress());
//			psmt.setString(5, vo.getmId());
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
	public int updateProfile(memberVO vo) { 
		String sql = "UPDATE member99 SET memberPassword=?, memberName=?"
				+ ", memberPhoneNumber=?, memberSiAddress=?, memberGuAddress=?"//
				+ " WHERE memberId=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberName());
			psmt.setString(3, vo.getMemberPhoneNumber());
			psmt.setString(4, vo.getMemberSiAddress());
			psmt.setString(5, vo.getMemberGuAddress());
			psmt.setString(6, vo.getMemberId());
			n = psmt.executeUpdate();
		} catch (Exception e) {
		} finally {
			close();
		}

		return n;
	}
//
////삭제
//	public int delete(memberVO vo) {
//		String sql = "DELETE FROM member WHERE mid=?";
//		int n = 0;
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getmId());
//			n = psmt.executeUpdate();
//			System.out.println(n + "건 삭제.");
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//
//		return n;
//	}
//
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
