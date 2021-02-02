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
		String sql1 = "UPDATE book99"//
				+ " SET bcount = bcount-1"//
				+ " WHERE bookcode = ?";
		
		String sql2 = "INSERT INTO bookrental99"//
				+ "(bookcode, memberid)"//
				+ " VALUES(?, ?)";
		
		String sql3 = "UPDATE book99 SET rentalCount = rentalCount + 1 WHERE bookcode = ?";
		
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
			
			psmt = conn.prepareStatement(sql3);
			psmt.setString(1, vo.getBookCode());
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
		String sql = "SELECT * FROM bookrental99 ORDER BY 1 DESC";
		BookRentalVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getString("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("RETURNDATE"));
				list.add(vo);
				System.out.println(vo.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookRentalVo select(BookRentalVo vo) {
		String sql = "SELECT * FROM bookrental99 WHERE rentaldate = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRentalDate());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setRentalDate(rs.getString("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("RETURNDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int returnBook(BookRentalVo vo) {
		int n = 0;
		String sql1 = "UPDATE book99"//
				+ " SET bcount = bcount+1"//
				+ " WHERE bookcode = ?";
		
		String sql2 = "UPDATE bookrental99"//
				+ " SET RETURNDATE = (to_char(sysdate,'yyyy/mm/dd hh24:mi:ss'))"//
				+ " WHERE rentalDate = ?";

		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, vo.getBookCode());
			System.out.println(vo.toString());
			n = psmt.executeUpdate();
			
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, vo.getRentalDate());
			System.out.println(vo.toString());
			n = psmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public ArrayList<BookRentalVo> selectListUSER(BookRentalVo vo1){
		ArrayList<BookRentalVo> list = new ArrayList<>();
		String sql = "SELECT * FROM bookrental99 WHERE memberid = ? ORDER BY 1 DESC";
		BookRentalVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo1.getMemberId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getString("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("RETURNDATE"));
				list.add(vo);
				System.out.println(vo.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public ArrayList<BookRentalVo> selectListNotReturn(){
		ArrayList<BookRentalVo> list = new ArrayList<>();
		String sql = "SELECT * FROM bookrental99 WHERE returndate IS NULL ORDER BY 1";
		BookRentalVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalDate(rs.getString("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("RETURNDATE"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public int returnBookListDelete(BookRentalVo vo) {
		int n = 0;
		String sql = "DELETE FROM bookrental99 WHERE rentaldate = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRentalDate());
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
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
