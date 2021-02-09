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
		String sql = "SELECT * FROM product ORDER BY pname";
		productVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new productVO();
				vo.setpName(rs.getString("pName"));
				vo.setpModel(rs.getString("pModel"));
				vo.setpImage(rs.getString("pImage"));
				vo.setpAgency(rs.getString("pAgency"));
				vo.setpColor(rs.getString("pColor"));
				vo.setpVolume(rs.getInt("pVolume"));
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
		String sql = "SELECT * FROM product WHERE pname=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpName());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setpName(rs.getString("pName"));
				vo.setpModel(rs.getString("pModel"));
				vo.setpImage(rs.getString("pImage"));
				vo.setpAgency(rs.getString("pAgency"));
				vo.setpColor(rs.getString("pColor"));
				vo.setpVolume(rs.getInt("pVolume"));
			}
		} catch (Exception e) {
		} finally {
			close();
		}
		return vo;
	}

//등록-value is 6
	public int insert(productVO vo) {
		String sql = "INSERT INTO product (pname, pmodel, pimage, pagency, pcolor, pvolume) VALUES (?,?,?,?,?,?)";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpName());
			psmt.setString(2, vo.getpModel());
			psmt.setString(3, vo.getpImage());
			psmt.setString(4, vo.getpColor());
			psmt.setInt(5, vo.getpVolume());
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
	public int update(productVO vo) {
		String sql = "UPDATE product SET pname=?, pmodel=?, pimage=?, pagency=?, pcolor=?, pvolume=?WHERE pName=?";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpName());
			psmt.setString(2, vo.getpModel());
			psmt.setString(3, vo.getpImage());
			psmt.setString(4, vo.getpAgency());
			psmt.setString(5, vo.getpColor());
			psmt.setInt(6, vo.getpVolume());
			psmt.setString(7, vo.getpName());
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
		String sql = "DELETE FROM product WHERE pname=?";
		int n = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getpName());
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
