package co.micol.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.common.DAO;
import co.micol.vo.BookVo;

public class BookDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<BookVo> selectList(){
		ArrayList<BookVo> list = new ArrayList<>();
		String sql = "SELECT * FROM book ORDER BY bookcode";
		BookVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookVo();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public BookVo select(BookVo vo) {
		String sql = "SELECT * FROM book WHERE bookcode = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public int insert(BookVo vo) {
		int n = 0;
		String sql = "INSERT INTO book"//
				+ "(bookcode, bookname)"//
				+ " VALUES(?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(BookVo vo) {
		int n = 0;
		String sql = "UPDATE book"//
				+ " SET bookname = ?"//
				+ ", quantity = ?"//
				+ ", bcount = ?"//
				+ " WHERE bookcode = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getQuantity());
			psmt.setInt(3, vo.getbCount());
			psmt.setString(4, vo.getBookCode());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BookVo vo) {
		int n = 0;
		String sql = "DELETE FROM book WHERE bookcode=?";
		try {
			psmt =  conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
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
