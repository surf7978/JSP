package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.textVO;
import co.micol.common.DAO;

public class textDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//전체조회	
	public ArrayList<textVO> selectList(){
		ArrayList<textVO> list = new ArrayList<textVO>();
		textVO vo;
		String sql="SELECT * FROM text";		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new textVO();
				vo.settNumber(rs.getString("tNumber"));
				vo.settTitle(rs.getString("tTitle"));
				vo.settContent(rs.getString("tContent"));
				vo.settDate(rs.getString("tDate"));
				vo.settPrice(rs.getInt("tPrice"));
				vo.settImage(rs.getString("timage"));
				vo.settAddress(rs.getString("tAddress"));
				vo.settId(rs.getString("tId"));
				vo.settDiscount(rs.getInt("tDiscount"));
				vo.settViews(rs.getInt("tViews"));
				vo.settLikes(rs.getInt("tLikes"));
				list.add(vo);				
			}			
		} catch (Exception e) {
		} finally {
			close();
		}
		
		return list;
		
	}
	
//선택조회
	public textVO select(textVO vo){
		String sql="SELECT * FROM text WHERE tNUMBER=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettNumber());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.settTitle(rs.getString("tTitle"));
				vo.settContent(rs.getString("tContent"));
				vo.settDate(rs.getString("tDate"));
				vo.settPrice(rs.getInt("tPrice"));
				vo.settImage(rs.getString("timage"));
				vo.settAddress(rs.getString("tAddress"));
				vo.settId(rs.getString("tId"));
				vo.settDiscount(rs.getInt("tDiscount"));
				vo.settViews(rs.getInt("tViews"));
				vo.settLikes(rs.getInt("tLikes"));
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		
		return vo;
	}

	
//등록
	public int insert(textVO vo) {	// 뷰, 라이크는 제외
		String sql="INSERT INTO text (tnumber,ttitle, tcontent, tdate, tprice, timage, taddress, tid, tdiscount) VALUES (text_seq.nextval,?,?,?,?,?,?,?,?)";
		int n =0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettNumber());
			psmt.setString(2, vo.gettTitle());
			psmt.setString(3, vo.gettContent());
			psmt.setString(4, vo.gettDate());
			psmt.setInt(5, vo.gettPrice() );
			psmt.setString(6, vo.gettImage());
			psmt.setString(7, vo.gettAddress());
			psmt.setString(8, vo.gettId());
			psmt.setInt(9, vo.gettDiscount());
			n = psmt.executeUpdate();
			System.out.println( n + "건 등록완료");
		} catch (Exception e) {
		} finally {
			close();
		}		
		return n;
	}
	
//수정
	public int update(textVO vo) { //제목,내용,가격,사진,주소,할인
		int n =0;
		String sql="UPDATE text SET tTitle= ?, tContent =?, tprice =?, timage=?, taddress=?, tdiscount=? WHERE tNumber=?";
	
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.gettTitle());
			psmt.setString(2, vo.gettContent());
			psmt.setInt(3, vo.gettPrice());
			psmt.setString(4, vo.gettImage());
			psmt.setString(5, vo.gettAddress());
			psmt.setInt(6, vo.gettDiscount());
			psmt.setString(7, vo.gettNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건 수정");
		} catch (Exception e) {
		} finally {
			close();
		}
		
		return n;
	}
//삭제
	public int delete(textVO vo) {
		int n =0;
		String sql="DELETE FROM text WHERE tNUMBER=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제");
		} catch (Exception e) {
		} finally {
			close();
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
