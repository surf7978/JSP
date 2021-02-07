package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.boardVO;
import co.micol.common.DAO;

public class boardDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//전체조회	
	public ArrayList<boardVO> selectBoardList(){
		ArrayList<boardVO> list = new ArrayList<boardVO>();
		boardVO vo;
		String sql="SELECT * FROM board99 ORDER BY boardDate DESC";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new boardVO();
				vo.setBoardView(rs.getInt("boardView"));
				vo.setBoardTitle(rs.getString("boardTitle"));
				vo.setProductName(rs.getString("productName"));
				vo.setPrice(rs.getInt("price"));
				vo.setMemberSiAddress(rs.getString("memberSiAddress"));
				vo.setMemberGuAddress(rs.getString("memberGuAddress"));
				vo.setMemberId(rs.getString("memberId"));
				vo.setBoardDate(rs.getString("boardDate"));
				list.add(vo);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
//선택조회
	public boardVO selectBoard(boardVO vo){
		String sql="SELECT * FROM board99 WHERE boardDate = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardDate());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardTitle(rs.getString("boardTitle"));
				vo.setBoardContent(rs.getString("boardContent"));
				vo.setBoardDate(rs.getString("boardDate"));
				vo.setBoardView(rs.getInt("boardView"));
				vo.setProductName(rs.getString("productName"));
				vo.setPrice(rs.getInt("price"));
				vo.setMemberId(rs.getString("memberId"));
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
	public int insertBoard(boardVO vo) {	// 뷰, 라이크는 제외
		String sql="INSERT INTO board99"//
				+ " (boardTitle, boardContent, price, productName"//
				+ ", memberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber, boardView)"//
				+ " VALUES (?,?,?,?"//
				+ ",?,?,?,?,?)";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardTitle());
			psmt.setString(2, vo.getBoardContent());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getProductName());
			psmt.setString(5, vo.getMemberId());
			psmt.setString(6, vo.getMemberSiAddress());
			psmt.setString(7, vo.getMemberGuAddress());
			psmt.setString(8, vo.getMemberPhoneNumber());
			psmt.setInt(9, vo.getBoardView());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return n;
	}
//	
////수정
//	public int update(boardVO vo) { //제목,내용,가격,사진,주소,할인
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
//	public int delete(boardVO vo) {
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
