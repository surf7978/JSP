package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.sellVO;
import co.micol.common.DAO;

public class sellDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//관리자의 유저 구매기록 전체 조회	
	public ArrayList<sellVO> selectSellList(){
		ArrayList<sellVO> list = new ArrayList<sellVO>();
		sellVO vo;
		String sql="SELECT * FROM Sell99 ORDER BY BuyDate DESC";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new sellVO();
				vo.setBuyMemberId(rs.getString("BuyMemberId"));
				vo.setBuyDate(rs.getString("BuyDate"));
				vo.setPrice(rs.getInt("price"));
				vo.setMemberId(rs.getString("memberId"));
				vo.setProductName(rs.getString("productName"));
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
////유저의 자신 구매내역 조회
//	public ArrayList<sellVO> selectSellListUSER(sellVO vo){
//		ArrayList<sellVO> list = new ArrayList<sellVO>();
//		sellVO vo1;
//		String sql="SELECT * FROM Sell99 WHERE MemberId = ? ORDER BY BuyDate DESC";		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getBuyMemberId());
//			rs = psmt.executeQuery();
//			while(rs.next()) {
//				vo1 = new sellVO();
//				vo1.setBuyDate(rs.getString("BuyDate"));
//				vo1.setBuyMemberId(rs.getString("BuyMemberId"));
//				vo1.setPrice(rs.getInt("price"));
//				vo1.setMemberId(rs.getString("memberId"));
//				list.add(vo1);				
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		return list;
//	}
	
////선택조회
//	public sellVO selectBoard(sellVO vo){
//		String sql="SELECT * FROM Sell99 WHERE BuyDate = ?";
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
	public int insertSell(sellVO vo) {	// 뷰, 라이크는 제외
		String sql="insert into Sell99(BuyDate, BuyMemberId, price, MemberId, productName)"//
				+ " VALUES (to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'),?,?,?,?)";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBuyMemberId());
			psmt.setInt(2, vo.getPrice());
			psmt.setString(3, vo.getMemberId());
			psmt.setString(4, vo.getProductName());
			n = psmt.executeUpdate();
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return n;
	}
	
//수정
	public void updateTradeProcess(sellVO vo) { //제목,내용,가격,사진,주소,할인
		String sql1 = "UPDATE sell99 SET tradeProcess = ?  WHERE BuyDate =?";
		String sql2 = "UPDATE buy99 SET tradeProcess = ?  WHERE BuyDate =?";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1,vo.getTradeProcess());
			psmt.setString(2, vo.getBuyDate());
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1,vo.getTradeProcess());
			psmt.setString(2, vo.getBuyDate());
			psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
////삭제
//	public int delete(sellVO vo) {
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
	
	public int averageTradeComplete(int n) {
		String sql1 ="select tradeProcess from sell99";
		String sql2 ="select tradeProcess from sell99 WHERE tradeProcess = 'Complete'";
		int a = 0;
		int b = 0;
		double c = 0;
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				a++;
			}
			System.out.println(a);
			psmt = conn.prepareStatement(sql2);
			rs= psmt.executeQuery();
			while(rs.next()) {
				b++;
			}
			System.out.println(b);
			c = b*100;
			System.out.println(c);
			n =(int) c/a;
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
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
