package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.commentVO;
import co.micol.common.DAO;

public class commentDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//전체조회	
	public ArrayList<commentVO> selectCommentList(){
		ArrayList<commentVO> list = new ArrayList<commentVO>();
		commentVO vo;
		String sql="SELECT * FROM comment99 ORDER BY commentDate DESC";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new commentVO();
				vo.setCommentDate(rs.getString("commentDate"));
				vo.setCommentContent(rs.getString("commentContent"));
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
	
////선택조회
	public ArrayList<commentVO> selectComment(commentVO vo){
		String sql="SELECT * FROM comment99 WHERE boardDate = ?";
		ArrayList<commentVO> list = new ArrayList<>();
		commentVO vo1;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardDate());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo1 = new commentVO();
				vo1.setCommentContent(rs.getString("commentContent"));
				vo1.setMemberId(rs.getString("memberId"));
				vo1.setCommentDate(rs.getString("commentDate"));
				list.add(vo1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	
//등록
	public int insertComment(commentVO vo) {	// 뷰, 라이크는 제외
		String sql="INSERT INTO comment99"//
				+ " (boardDate, commentContent, memberId)"//
				+ " VALUES (?,?,?)";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardDate());
			psmt.setString(2, vo.getCommentContent());
			psmt.setString(3, vo.getMemberId());
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
//	public int update(commentVO vo) { //제목,내용,가격,사진,주소,할인
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
//	public int delete(commentVO vo) {
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
	
	public int countComment(int n) {
		String sql = "select memberid from comment99";
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
