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
	
	public void startSetting() {
		String sql1 = "create table book99"//
				+ "(BookCode varchar2(4) not null primary key"//
				+ ", BookName varchar2(100) not null"//
				+ ", Quantity number default 5 not null"//
				+ ", bCount number default 5 not null)";
		String sql2 = "insert into book99(bookcode, bookname) values('1111','1번책')";
		String sql3 = "insert into book99(bookcode, bookname) values('222','2번책')";
		String sql4 = "insert into book99(bookcode, bookname) values('33','3번책')";
		String sql5 = "create table member99(MemberId varchar2(10) not null primary key"//
				+ ", MemberName varchar2(20) not null"//
				+ ", MemberPassword varchar2(20) not null"//
				+ ", MemberTel varchar2(20) not null"//
				+ ", MemberAddress varchar2(100)"//
				+ ", MemberAuth varchar2(10) default 'USER')";
		String sql6 = "insert into member99"//
				+ "(MemberId, MemberName, MemberPassword, MemberTel, MemberAddress, MemberAuth)"//
				+ " values('admin','관리자', 'admin', '010-1111-2222', '대구시', 'ADMIN')";
		String sql7 = "insert into member99"
				+ "(MemberId, MemberName, MemberPassword, MemberTel, MemberAddress)"
				+ " values('park','박', '1234', '010-1234-5678', '서울시')";
		String sql8 ="create table bookrental99"//
				+ "(RentalDate varchar2(20) default to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') not null"//
				+ ", BookCode varchar2(4) not null"//
				+ ", MemberId varchar2(10) not null"//
				+ ", ReturnDate varchar2(20))";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql2);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql3);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql4);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql5);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql6);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql7);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql8);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void endSetting() {
		String sql1 ="drop table book99";
		String sql2 ="drop table member99";
		String sql3 ="drop table bookrental99";
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql2);
			psmt.executeQuery();
			psmt = conn.prepareStatement(sql3);
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public ArrayList<BookVo> selectList(){
		ArrayList<BookVo> list = new ArrayList<>();
		String sql = "SELECT * FROM book99 ORDER BY bookcode";
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
		String sql = "SELECT * FROM book99 WHERE bookcode = ?";
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
		String sql = "INSERT INTO book99"//
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
		String sql = "UPDATE book99"//
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
		String sql = "DELETE FROM book99 WHERE bookcode=?";
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
