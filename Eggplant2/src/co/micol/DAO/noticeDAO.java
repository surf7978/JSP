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
		String sql = "SELECT * FROM NOTICE99 ORDER BY NDATE DESC";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new noticeVO();
				vo.setnNumber(rs.getInt("nNumber"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnDate(rs.getString("nDate"));
				vo.setMemberId(rs.getString("memberId"));
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
		String sql = "SELECT * FROM NOTICE99 WHERE nDate =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnDate());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setnNumber(rs.getInt("nNumber"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnDate(rs.getString("nDate"));
				vo.setMemberId(rs.getString("memberId"));
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
		String sql = "UPDATE NOTICE99 SET nTITLE=?, nCONTENT=? WHERE nDATE=?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnTitle());
			psmt.setString(2, vo.getnContent());
			psmt.setString(3, vo.getnDate());
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
		String sql = "insert into notice99( nTITLE, nCONTENT, memberId, nWriter)"
				+ " values( ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnTitle());
			psmt.setString(2, vo.getnContent());
			psmt.setString(3, vo.getMemberId());
			psmt.setString(4, vo.getnWriter());
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
		String sql = "DELETE FROM NOTICE99 WHERE nDate=?";
		int n=0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getnDate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		return n;
	}
	
	public int alertNote(noticeVO vo) {
		String sql ="select memberId from notice99 WHERE memberId = ?";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			while(rs.next()) {
				n++;
			}
			System.out.println(n);
		} catch (SQLException e) {
			e.printStackTrace();
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
