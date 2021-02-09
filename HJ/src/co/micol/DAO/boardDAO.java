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
				vo.setProductImage(rs.getString("productImage"));
				vo.setProductVolume(rs.getInt("productVolume"));
				vo.setProductColor(rs.getString("productColor"));
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
				vo.setProductImage(rs.getString("productImage"));
				vo.setProductVolume(rs.getInt("productVolume"));
				vo.setProductColor(rs.getString("productColor"));
				vo.setTradeProcess(rs.getString("tradeProcess"));
				updateView(vo);
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
				+ ", memberId, MemberSiAddress, MemberGuAddress, MemberPhoneNumber,ProductImage,ProductVolume,ProductColor)"//
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
			psmt.setString(9, vo.getProductImage());
			psmt.setInt(10, vo.getProductVolume());
			psmt.setString(11, vo.getProductColor());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return n;
	}

	public void updateView(boardVO vo) {
		String sql = "UPDATE board99 SET boardView = boardView + 1 WHERE boardDate = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardDate());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
//수정
	public int updateBoard(boardVO vo) { //제목,내용,가격,사진,주소,할인
		int n =0;
		String sql="UPDATE board99 SET BoardTitle= ?, BoardContent =?, price =?, memberSiAddress=?, memberGuAddress=?,productImage=?, productVolume=?, productColor=?,tradeProcess =? WHERE BoardDate =?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getBoardTitle());
			psmt.setString(2, vo.getBoardContent());
			psmt.setInt(3, vo.getPrice());
			psmt.setString(4, vo.getMemberSiAddress());
			psmt.setString(5, vo.getMemberGuAddress());
			psmt.setString(6, vo.getProductImage());
			psmt.setInt(7, vo.getProductVolume());
			psmt.setString(8, vo.getProductColor());
			psmt.setString(9, vo.getTradeProcess());
			psmt.setString(10, vo.getBoardDate());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
//삭제
	public int deleteBoard(boardVO vo) {
		int n =0;
		String sql="DELETE FROM board99 WHERE boardDate=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardDate());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제");
		} catch (Exception e) {
		} finally {
			close();
		}		
		return n;
	}

	
	
	public int countBoard(int n) {
		String sql = "select memberid from board99";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				n++;
			}
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return n;
	}
	
	public int sumPrice(int n) {
		String sql = "select sum(price) from board99";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("sum(price)"));
				n = rs.getInt("sum(price)");
			}
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
