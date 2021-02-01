package co.micol.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.common.DAO;
import co.micol.vo.BookRentalVo;

public class BookRentalDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public int rental(BookRentalVo vo) {
		int n = 0;
		String sql1 = "UPDATE book"//
				+ " SET bcount = bcount-1"//
				+ " WHERE bookcode = ?";
		
		String sql2 = "INSERT INTO bookrental"//
				+ "(rentaldate, bookcode, memberid)"//
				+ " VALUES(SYSDATE, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, vo.getBookCode());
			System.out.println(vo.toString());
			n = psmt.executeUpdate();
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getMemberId());
			System.out.println(vo.toString());
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public ArrayList<BookRentalVo> selectList(){
		ArrayList<BookRentalVo> list = new ArrayList<>();
		String sql = "SELECT * FROM bookrental ORDER BY 1";
		BookRentalVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookRentalVo select(BookRentalVo vo) {
		String sql = "SELECT * FROM bookrental WHERE rentaldate = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setDate(1, vo.getRentalDate());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
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
