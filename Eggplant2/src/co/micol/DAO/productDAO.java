package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.productVO;
import co.micol.common.DAO;

public class productDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

//전체조회	
	public ArrayList<productVO> selectList() {
		ArrayList<productVO> list = new ArrayList<productVO>();
		String sql = "SELECT * FROM Product99 ORDER BY ProductName DESC";
		productVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new productVO();
				vo.setProductName(rs.getString("ProductName"));
				vo.setProductImage(rs.getString("ProductImage"));
				vo.setCategory1(rs.getString("Category1"));
				vo.setCategory2(rs.getString("Category2"));
				list.add(vo);
			}

		} catch (Exception e) {
		} finally {
			close();
		}

		return list;

	}

//선택조회
	public productVO select(productVO vo) {
		String sql = "SELECT * FROM ProductName99 WHERE ProductNameName=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setProductName(rs.getString("ProductName"));
				vo.setProductImage(rs.getString("ProductImage"));
				vo.setCategory1(rs.getString("Category1"));
				vo.setCategory2(rs.getString("Category2"));
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return vo;
	}

//등록-value is 6
	public int insert(productVO vo) {
		String sql = "INSERT INTO ProductName99 (ProductName, ProductImage, Category1, Category2)"
				+ " VALUES (?,?,?,?)";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			psmt.setString(2, vo.getProductImage());
			psmt.setString(3, vo.getCategory1());
			psmt.setString(4, vo.getCategory2());
			n = psmt.executeUpdate();
			System.out.println(n + "건 등록.");
		} catch (Exception e) {
		} finally {
			close();
		}

		return n;
	}

//수정-value is 7
// 실행시 아마 오류날 것 2차수정필요
	public int updateProduct(productVO vo) {
		String sql = "UPDATE ProductName99 SET ProductImage=?, Category1=?, Category2=? WHERE ProductName=?";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductImage());
			psmt.setString(2, vo.getCategory1());
			psmt.setString(3, vo.getCategory2());
			psmt.setString(4, vo.getProductName());
			n = psmt.executeUpdate();
			System.out.println(n + "건 업데이트.");
		} catch (Exception e) {
		} finally {
			close();
		}
		return n;
	}

//삭제
	public int delete(productVO vo) {
		String sql = "DELETE FROM ProductName99 WHERE ProductNameName=?";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProductName());
			n = psmt.executeUpdate();
			System.out.println(n + "건 삭제.");
		} catch (Exception e) {
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
