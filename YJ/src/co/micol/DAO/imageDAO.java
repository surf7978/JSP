package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.imageVO;
import co.micol.common.DAO;

public class imageDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<imageVO> selectList(){
		ArrayList<imageVO> list = new ArrayList<imageVO>();
		imageVO vo;
		String sql = "select * from image";
		try {
			psmt = conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo = new imageVO();
				vo.setImagetest(rs.getString("imageTest"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(imageVO vo) {
		String sql = "insert into image values (?)";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getImagetest());
			n=psmt.executeUpdate();
			System.out.println(n + "건 등록.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	

}
