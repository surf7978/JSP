package co.mini.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mini.board.common.DAO;
import co.mini.board.vo.BookVo;

public class BookDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	// select list
	public ArrayList<BookVo> selectList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo;
		String sql = "SELECT * FROM BOOK ORDER BY TO_NUMBER(BOOKCODE)";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookVo();
				vo.setBookCode(rs.getString("bookcode"));
				vo.setBookName(rs.getString("bookname"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

	// 관리자 도서 등록 ***************

	public int insert(BookVo vo) {
		int n = 0;

		String sql = "INSERT INTO BOOK(BOOKCODE,BOOKNAME) VALUES(BOOK_SEQ.NEXTVAL, ?)";

		if (vo.getQuantity() != 0) {
			sql = "INSERT INTO BOOK(BOOKCODE,BOOKNAME,QUANTITY, BCOUNT) VALUES(BOOK_SEQ.NEXTVAL, ?,?,?)";

		}

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());

			if (vo.getQuantity() != 0) {
				psmt.setInt(2, vo.getQuantity());
				psmt.setInt(3, vo.getQuantity());
			}

			n = psmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 도서 수정 *****************8

	// 도서 삭제 ********************8
	// select2 (�����ڿ� ��ü �뿩���) ************88
	public ArrayList<BookVo> selectAmList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo;
		String sql = "SELECT* FROM BOOK ORDER BY BOOKCODE";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookVo();
				vo.setBookCode(rs.getString("bookCode"));
				vo.setBookName(rs.getString("bookName"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bCount"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}

	// select3 (�����ڿ� �ϳ� �뿩���--����)**********
	public BookVo selectoneAdminList(BookVo vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new BookVo();
				vo.setBookCode(rs.getString("bookCode"));
				vo.setBookName(rs.getString("bookName"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bCount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// ������ ���� ��� ***************

	public int insertAdmin(BookVo vo) {
		int n = 0;

		String sql = "insert into book values(BOOK_SEQ.nextval,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getQuantity());
			psmt.setInt(3, vo.getbCount());

			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// ���� ���� *****************8

	public int update(BookVo vo) {
		int n = 0;

		String sql = "UPDATE BOOK SET BOOKNAME=?, BCOUNT=?, QUANTITY=? WHERE BOOKCODE=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookName());
			psmt.setInt(2, vo.getbCount());
			psmt.setInt(3, vo.getQuantity());
			psmt.setString(4, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// ���� ���� ********************8

	public int delete(BookVo vo) {
		int n = 0;

		String sql = "DELETE FROM BOOK WHERE BOOKCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

//close
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
