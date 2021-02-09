package co.micol.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.VO.noticeVO;
import co.micol.common.DAO;

public class noticeDAO extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<noticeVO> selectList(){
		ArrayList<noticeVO> list = new ArrayList<noticeVO>();
		noticeVO vo;
		String sql = "SELECT * FROM NOTICE ORDER BY NNUMBER DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new noticeVO();
				vo.setnNumber(rs.getInt("nNumber"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnDate(rs.getDate("nDate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public noticeVO noticeSelect(noticeVO vo) {
		String sql = "SELECT * FROM NOTICE WHERE NNUMBER =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getnNumber());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setnNumber(rs.getInt("nNumber"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnDate(rs.getDate("nDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}
	public int noticeUpdate(noticeVO vo) {
		String sql = "UPDATE NOTICE SET NTITLE=?, NCONTENT=?, NDATE=SYSDATE WHERE NNUMBER=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnTitle());
			psmt.setString(2, vo.getnContent());
			psmt.setInt(3, vo.getnNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건 업데이트.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}		
		return n;	
	}
	
	public int noticeInsert(noticeVO vo) {
		String sql = "insert into notice values(notice_seq.nextval, ?, ?, '관리자', sysdate)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnTitle());
			psmt.setString(2, vo.getnContent());
			n = psmt.executeUpdate();
			System.out.println(n+"건 등록.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		return n;
	}
	
	public int noticeDelete(noticeVO vo) {
		String sql = "DELETE FROM NOTICE WHERE NNUMBER=?";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getnNumber());
			n = psmt.executeUpdate();
			System.out.println(n + "건 삭제.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		return n;
	}
	//닫기
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
