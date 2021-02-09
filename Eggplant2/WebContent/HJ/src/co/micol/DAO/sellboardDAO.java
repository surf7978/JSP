package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.sellboardVO;
import co.micol.common.DAO;

public class sellboardDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

//전체조회	
	public ArrayList<sellboardVO> selectList() {
		ArrayList<sellboardVO> list = new ArrayList<sellboardVO>();
		sellboardVO vo;
		String sql = "SELECT * FROM sellboard";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new sellboardVO();
				vo.settNumber(rs.getString("tNumber"));
				vo.settTitle(rs.getString("tTitle"));
				vo.settContent(rs.getString("tContent"));
				vo.settDate(rs.getString("tDate"));
				vo.settPrice(rs.getInt("tPrice"));
				vo.settImage(rs.getString("timage"));
				vo.settAddress(rs.getString("tAddress"));
				vo.settId(rs.getString("tId"));
				vo.settDiscount(rs.getInt("tDiscount"));
				vo.setpName(rs.getString("pName"));
				vo.setpColor(rs.getString("pColor"));
				vo.setpVolume(rs.getInt("pVolume"));
				list.add(vo);
				System.out.println(vo);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
			finally {
			close();
		}
		return list;
	}

//선택조회
	public sellboardVO select(sellboardVO vo) {
		String sql = "SELECT * FROM sellboard WHERE tNUMBER=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettNumber());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.settTitle(rs.getString("tTitle"));
				vo.settContent(rs.getString("tContent"));
				vo.settDate(rs.getString("tDate"));
				vo.settPrice(rs.getInt("tPrice"));
				vo.settImage(rs.getString("timage"));
				vo.settAddress(rs.getString("tAddress"));
				vo.settId(rs.getString("tId"));
				vo.settDiscount(rs.getInt("tDiscount"));
				vo.setpName(rs.getString("pName"));
				vo.setpColor(rs.getString("pColor"));
				vo.setpVolume(rs.getInt("pVolume"));
			}
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

//등록
	public int insert(sellboardVO vo) { // 뷰, 라이크는 제외
		String sql = "INSERT INTO sellboard (TNUMBER, TTITLE, TCONTENT, TDATE, TPRICE, TIMAGE, TADDRESS, TID, TDISCOUNT, PNAME, PCOLOR, PVOLUME) "
				+ "VALUES (text_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettTitle());
			psmt.setString(2, vo.gettContent());
			psmt.setString(3, vo.gettDate());
			psmt.setInt(4, vo.gettPrice());
			psmt.setString(5, vo.gettImage());
			psmt.setString(6, vo.gettAddress());
			psmt.setString(7, vo.gettId());
			psmt.setInt(8, vo.gettDiscount());
			psmt.setString(9, vo.getpName());
			psmt.setString(10, vo.getpColor());
			psmt.setInt(11, vo.getpVolume());
			n = psmt.executeUpdate();
			System.out.println(n + "건 등록완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

//수정
	public int update(sellboardVO vo) { // 제목,내용,가격,사진,주소,할인
		int n = 0;
		String sql = "UPDATE sellboard SET ttitle = ?, tcontent=?, tprice=?, timage=?, taddress=?,tdiscount=?, pname=?,pcolor=?, pvolume=?\r\n"
				+ "WHERE tnumber=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettTitle());
			psmt.setString(2, vo.gettContent());
			psmt.setInt(3, vo.gettPrice());
			psmt.setString(4, vo.gettImage());
			psmt.setString(5, vo.gettAddress());
			psmt.setInt(6, vo.gettDiscount());
			psmt.setString(7, vo.getpName());
			psmt.setString(8, vo.getpColor());
			psmt.setInt(9, vo.getpVolume());
			psmt.setString(10, vo.gettNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건 수정");
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

//삭제
	public int delete(sellboardVO vo) {
		int n = 0;
		String sql = "DELETE FROM sellboard WHERE tNUMBER=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.gettNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건이 삭제");
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			conn.close();
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
