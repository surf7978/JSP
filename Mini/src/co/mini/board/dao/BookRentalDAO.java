package co.mini.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mini.board.common.DAO;
import co.mini.board.vo.BookRentalVo;

public class BookRentalDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

//관리자용 조회(전체 대여 조회기능)
	
	public ArrayList<BookRentalVo> SelectAdminRental() {
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo;
		String sql = "SELECT A.BOOKCODE, A.BOOKNAME, A.QUANTITY,B.RENTALDATE,B.MEMBERID,B.RETURNDATE,B.RENTALCODE  FROM BOOK A FULL OUTER JOIN BOOKRENTAL B ON A.BOOKCODE=B.BOOKCODE WHERE B.RENTALDATE IS NOT NULL";
		
		try {
			psmt= conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo=new BookRentalVo();
				vo.setRentalCode(rs.getInt("rentalcode"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getDate("returndate"));
				vo.setBookName(rs.getString("bookname"));
				list.add(vo);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

//회원용 조회
	public ArrayList<BookRentalVo> SelectUserRental(BookRentalVo m) {

		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		BookRentalVo vo;
		String sql = "SELECT * FROM BOOK A, BOOKRENTAL B WHERE A.BOOKCODE=B.BOOKCODE AND B.MEMBERID=? AND NVL(B.RETURNDATE,SYSDATE)>SYSDATE-30 ORDER BY RENTALCODE DESC";

		try {

			
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookRentalVo();
				vo.setRentalCode(rs.getInt("rentalcode"));
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setBookCode(rs.getString("bookcode"));
				vo.setMemberId(rs.getString("memberid"));
				vo.setReturnDate(rs.getDate("returndate"));
				vo.setBookName(rs.getString("bookname"));
				list.add(vo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close();
		}

		return list;

	}

//대출 전 조회
	public int AlreadyRental(BookRentalVo vo) {
		int ar=0;
		String sql = "SELECT BOOKCODE FROM BOOKRENTAL WHERE BOOKCODE=? AND MEMBERID=? AND RETURNDATE IS NULL";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getMemberId());
			rs = psmt.executeQuery();
			while (rs.next()) {
				ar++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ar;
	}

//대출
	public ArrayList<BookRentalVo> Rental(BookRentalVo vo) {
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();

		int n = 0;
		int n2 = 0;

		String sql = "UPDATE BOOK SET BCOUNT=(BCOUNT-1) WHERE BOOKCODE=? AND BCOUNT>0";

		try {
			psmt = conn.prepareStatement(sql);
			System.out.println(vo.getBookCode());
			psmt.setString(1, vo.getBookCode());
			n = psmt.executeUpdate();
			System.out.println("1번업데이트 n값:"+n);

			if (n != 0) {
				System.out.println();
				sql = "INSERT INTO BOOKRENTAL(RENTALCODE,RENTALDATE,BOOKCODE,MEMBERID) VALUES((RENTAL_SEQ.NEXTVAL),SYSDATE,?,?)";

				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getBookCode());
				psmt.setString(2, vo.getMemberId());

				n2 = psmt.executeUpdate();
				System.out.println("n2값은:" + n2);
				if (n2 != 0) {
					sql = "SELECT * FROM BOOKRENTAL WHERE MEMBERID=?";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getMemberId());

					rs = psmt.executeQuery();
					while (rs.next()) {
						vo = new BookRentalVo();
						vo.setBookCode(rs.getString("bookcode"));
						vo.setMemberId(rs.getString("memberid"));
						list.add(vo);
					}
				} else if (n2 == 0) {
					sql = "UPDATE BOOK SET BCOUNT=(BCOUNT+1) WHERE BOOKCODE=?";
					psmt = conn.prepareStatement(sql);
					System.out.println(vo.getBookCode());
					psmt.setString(1, vo.getBookCode());

					n = psmt.executeUpdate();
				}

			}

		} catch (SQLException e) {
			System.out.println("대출실패");
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

//반납
	public int Return(BookRentalVo vo) {
		int n = 0;
		int n2 = 0;

		String sql = "UPDATE (SELECT BCOUNT FROM BOOK A, BOOKRENTAL B WHERE A.BOOKCODE=B.BOOKCODE AND B.RENTALCODE=? AND B.MEMBERID=? AND A.QUANTITY >A.BCOUNT) SET BCOUNT=(BCOUNT+1)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getRentalCode());
			psmt.setString(2, vo.getMemberId());

			n = psmt.executeUpdate();

			if (n != 0) {
				sql = "UPDATE (SELECT RETURNDATE FROM BOOK A, BOOKRENTAL B WHERE A.BOOKCODE=B.BOOKCODE AND B.RENTALCODE=? AND B.MEMBERID=?) SET RETURNDATE=SYSDATE";

				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getRentalCode());
				psmt.setString(2, vo.getMemberId());

				n2 = psmt.executeUpdate();

			}

		} catch (SQLException e) {
			System.out.println("반납실패");
			e.printStackTrace();
		} finally {
			close();
		}

		return n + n2;
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
