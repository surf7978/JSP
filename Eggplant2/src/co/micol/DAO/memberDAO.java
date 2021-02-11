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
				+ " values('admin','admin', '관리자', 'ADMIN', '대구광역시', '달서구', '010-1111-1111')";
		String sql3 = "insert into member99"//
				+ "(MemberId, MemberPassword, MemberName, MemberAuth, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('park','1234', '박', 'USER', '대구광역시', '서구', '010-2222-2222')";
		String sql4 = "insert into member99"//
				+ "(MemberId, MemberPassword, MemberName, MemberAuth, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " values('kim','1234', '김', 'USER', '대구광역시', '달성군', '010-3333-3333')";
		
		String sql5 = "create table board99(BoardTitle varchar2(100) not null"//
				+ ", BoardContent varchar2(1000) not null"//
				+ ", BoardDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"// 
				+ ", BoardView number default 0 not null, price number default 100 not null"
				+ ", ProductName varchar2(100) not null, MemberId varchar2(10) not null"
				+ ", MemberSiAddress varchar2(100) not null, MemberGuAddress varchar2(100) not null"
				+ ", MemberPhoneNumber varchar2(20) not null"
				+ ", ProductImage varchar2(100) not null"//
				+ ", ProductVolume number"//
				+ ", ProductColor varchar2(100)"//
				+ ", Category1 varchar2(20)"//
				+ ", Category2 varchar2(20)"//
				+ ", tradeProcess varchar2(20) default 'NotComplete' not null"
				+ " )";
		
		String sql6 = "insert into board99"//
				+ "(BoardTitle, BoardContent, ProductName, MemberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber"
				+ ", Category1, Category2, productImage)"//
				+ " values('폰팝니다','제곧내', '갤럭시s9', 'park', '대구시', '서구', '010-2222-2222', '전자기기', '스마트폰'"
				+ ", '01.jpg')";
		
		String sql7 = "create table buy99"//
				+ "(BuyDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"//
				+ ", BuyMemberId varchar2(20) not null"// 
				+ ", BoardDate varchar2(20) not null"// 
				+ ", price number default 100 not null"//
				+ ", ProductName varchar2(100) not null"//
				+ ", MemberId varchar2(10) not null"//
				+ ", MemberSiAddress varchar2(100) not null"//
				+ ", MemberGuAddress varchar2(100) not null"//
				+ ", tradeProcess varchar2(20) default 'NotComplete' not null"//
				+ ", MemberPhoneNumber varchar2(20) not null"
				+ " )";
		
		String sql8 = "create table product99"//
				+ "("//
				+ "ProductName varchar2(100) not null"
				+ ", productImage varchar2(100)"
				+ ", Category1 varchar2(100)"
				+ ", Category2 varchar2(100)"
				+ " )";
		
		String sql9 = "insert into product99"//
				+ "(ProductName, productImage, Category1, Category2 )"//
				+ " values('갤럭시s9','갤럭시s9.png', '전자기기', '스마트폰')";
		String sql10 = "insert into product99"//
				+ "(ProductName, productImage, Category1, Category2 )"//
				+ " values('아이폰12','아이폰12.png', '전자기기', '스마트폰')";
		String sql11 = "insert into product99"//
				+ "(ProductName, productImage, Category1, Category2 )"//
				+ " values('상의','상의.png', '의류', '상의')";
		String sql12 = "insert into product99"//
				+ "(ProductName, productImage, Category1, Category2 )"//
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
		String sql15 = "insert into Sell99(BuyDate, BuyMemberId, price, MemberId, productName)"//
				+ " VALUES (to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'), 'kim' , 100, 'park', '갤럭시s9')";
		
		String sql16 = "insert into buy99(BuyMemberId, BoardDate, price, ProductName"//
				+ ", MemberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " VALUES ('kim', to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'), 100, '갤럭시s9'"
				+ ", 'park', '대구시', '서구', '010-2222-2222')";
		
		String sql17 = "create table cart99"//
				+ "("//
				+ "CartMemberId varchar2(20) not null"//
				+ ", CartDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"//
				+ ", BoardDate varchar2(20) not null"// 
				+ ", price number default 100 not null"//
				+ ", MemberId varchar2(10) not null"//
				+ ", MemberSiAddress varchar2(100) not null"//
				+ ", MemberGuAddress varchar2(100) not null"//
				+ ", tradeProcess varchar2(20) default 'NotComplete' not null"//
				+ ", ProductName varchar2(100) not null"//
				+ ", MemberPhoneNumber varchar2(20) not null"
				+ " )";
		
		String sql18 = "create table notice99"//
				+ "("//
				+ "nContent varchar2(100) not null"//
				+ ", nTitle varchar2(100) not null"//
				+ ", nNumber varchar2(10)"//
				+ ", nWriter varchar2(10) not null"//
				+ ", MemberId varchar2(10) default 'notice'"//
				+ ", nDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"//
				+ " )";
		String sql19 = "insert into notice99(nNumber, nTITLE, nCONTENT, nWriter)"
				+ " values('1', '1번공지 제목입니다.', '1번공지 내용입니다.', 'admin')";
		String sql20 = "insert into notice99(nNumber, nTITLE, nCONTENT, nWriter)"
				+ " values('2', '2번공지 제목입니다.', '2번공지 내용입니다.', 'admin')";
		
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
			psmt = conn.prepareStatement(sql15);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql16);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql17);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql18);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql19);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql20);
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
		String sql7 ="drop table cart99";
		String sql8 ="drop table notice99";
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

//등록
	public void insertMember(memberVO vo) { 
		String sql = "INSERT INTO member99"
				+"(MemberId, MemberPassword, MemberName"
				+ ", MemberPhoneNumber, MemberSiAddress, MemberGuAddress)"
				+ " VALUES(?,?,?"
				+ ",?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberPhoneNumber());
			psmt.setString(5, vo.getMemberSiAddress());
			psmt.setString(6, vo.getMemberGuAddress());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

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

	//아이디채크
		public int isIdCheck(String id) {
			int cnt = 0;
			String sql = "SELECT memberId FROM MEMBER99 WHERE lower(memberId) = ?";

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if (rs.next()) {
					cnt = 1;// 아이디 있으면 1
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("아이디 중복확인 실패");
			} finally {
				close();
			}
			return cnt;
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
