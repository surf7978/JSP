package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.reviewVO;
import co.micol.common.DAO;

public class reviewDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//전체조회	
	public ArrayList<reviewVO> selectList(){
		String sql="SELECT * FROM review";

		try {
			psmt = conn.prepareStatement(sql);

		} catch (Exception e) {
		} finally {
			close();
		}
		
		return null;
		
	}
	
//선택조회
	public reviewVO select(reviewVO vo){
		String sql="SELECT * FROM review WHERE rnumber=?";
		try {
			psmt = conn.prepareStatement(sql);

		} catch (Exception e) {
		} finally {
			close();
		}
		return null;
	}

	
//등록
	public int insert(reviewVO vo) {
		String sql="";
		int n =0;
		
		try {
			psmt = conn.prepareStatement(sql);

		} catch (Exception e) {
		} finally {
			close();
		}
		return n;
	}
//수정
	public int update(reviewVO vo) {
		String sql="";
		int n =0;
		
		try {
			psmt = conn.prepareStatement(sql);

		} catch (Exception e) {
		} finally {
			close();
		}
		return n;
	}
//삭제
	public int delete(reviewVO vo) {
		String sql="";
		int n =0;
		
		try {
			psmt = conn.prepareStatement(sql);

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
