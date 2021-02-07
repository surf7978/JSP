package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.buyVO;
import co.micol.common.DAO;

public class buyDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//관리자의 유저 구매기록 전체 조회	
	public ArrayList<buyVO> selectBuyList(){
		ArrayList<buyVO> list = new ArrayList<buyVO>();
		buyVO vo;
		String sql="SELECT * FROM buy99 ORDER BY BuyDate DESC";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new buyVO();
				vo.setBuyDate(rs.getString("BuyDate"));
				vo.setBuyMemberId(rs.getString("BuyMemberId"));
				vo.setBoardDate(rs.getString("boardDate"));
				vo.setPrice(rs.getInt("price"));
				vo.setProductName(rs.getString("productName"));
				vo.setMemberId(rs.getString("memberId"));
				vo.setMemberSiAddress(rs.getString("memberSiAddress"));
				vo.setMemberGuAddress(rs.getString("memberGuAddress"));
				vo.setMemberPhoneNumber(rs.getString("MemberPhoneNumber"));
				vo.setTradeProcess(rs.getString("tradeProcess"));
				list.add(vo);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
//유저의 자신 구매내역 조회
	public ArrayList<buyVO> selectBuyListUSER(buyVO vo){
		ArrayList<buyVO> list = new ArrayList<buyVO>();
		buyVO vo1;
		String sql="SELECT * FROM buy99 WHERE buyMemberId = ? ORDER BY BuyDate DESC";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBuyMemberId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo1 = new buyVO();
				vo1.setBuyDate(rs.getString("BuyDate"));
				vo1.setBuyMemberId(rs.getString("BuyMemberId"));
				vo1.setBoardDate(rs.getString("boardDate"));
				vo1.setPrice(rs.getInt("price"));
				vo1.setProductName(rs.getString("productName"));
				vo1.setMemberId(rs.getString("memberId"));
				vo1.setMemberSiAddress(rs.getString("memberSiAddress"));
				vo1.setMemberGuAddress(rs.getString("memberGuAddress"));
				vo1.setMemberPhoneNumber(rs.getString("MemberPhoneNumber"));
				vo.setTradeProcess(rs.getString("tradeProcess"));
				list.add(vo1);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
////선택조회
//	public buyVO selectBoard(buyVO vo){
//		String sql="SELECT * FROM buy99 WHERE buyDate = ?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getBuyDate());
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				vo.setBoardDate(rs.getString("boardDate"));
//				vo.setBuyDate(rs.getString("BuyDate"));
//				vo.setProductName(rs.getString("productName"));
//				vo.setPrice(rs.getInt("price"));
//				vo.setMemberId(rs.getString("memberId"));
//				vo.setMemberSiAddress(rs.getString("memberSiAddress"));
//				vo.setMemberGuAddress(rs.getString("memberGuAddress"));
//				vo.setMemberPhoneNumber(rs.getString("memberPhoneNumber"));
//			}
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//		
//		return vo;
//	}

	
//등록
	public int insertBuy(buyVO vo) {	// 뷰, 라이크는 제외
		String sql="insert into buy99(BuyMemberId, BoardDate, price, ProductName"//
				+ ", MemberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber)"//
				+ " VALUES (?,?,?,?,?,?,?,?)";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBuyMemberId());
			psmt.setString(2, vo.getBoardDate());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getProductName());
			psmt.setString(5, vo.getMemberId());
			psmt.setString(6, vo.getMemberSiAddress());
			psmt.setString(7, vo.getMemberGuAddress());
			psmt.setString(8, vo.getMemberPhoneNumber());
			n = psmt.executeUpdate();
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return n;
	}
//	
////수정
//	public int update(buyVO vo) { //제목,내용,가격,사진,주소,할인
//		int n =0;
//		String sql="UPDATE text SET tTitle= ?, tContent =?, tprice =?, timage=?, taddress=?, tdiscount=? WHERE tNumber=?";
//	
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1,vo.gettTitle());
//			psmt.setString(2, vo.gettContent());
//			psmt.setInt(3, vo.gettPrice());
//			psmt.setString(4, vo.gettImage());
//			psmt.setString(5, vo.gettAddress());
//			psmt.setInt(6, vo.gettDiscount());
//			psmt.setString(7, vo.gettNumber());
//			n = psmt.executeUpdate();
//			System.out.println(n + "건 수정");
//		} catch (Exception e) {
//		} finally {
//			close();
//		}
//		
//		return n;
//	}
////삭제
//	public int delete(buyVO vo) {
//		int n =0;
//		String sql="DELETE FROM text WHERE tNUMBER=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.gettNumber());
//			n = psmt.executeUpdate();
//			System.out.println(n + "건이 삭제");
//		} catch (Exception e) {
//		} finally {
//			close();
//		}		
//		return n;
//	}
	
	private void close() {
		try {
			conn.close();
			if(rs != null) {rs.close();}
			if(psmt != null) {psmt.close();}
			if(conn != null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
