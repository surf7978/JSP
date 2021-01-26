package co.micol.mvc.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.mvc.board.service.BoardVO;
import co.micol.mvc.common.DAO;

public class BoardsDAO extends DAO{ //공용 DAO만들고 extends함
	//보드테이블 접속하는 DAO
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private final String BOARDSELECTLIST="SELECT * FROM BOARDS ORDER BY 1 DESC"; //final String = 수정금지
	private final String BOARDSELECT = "SELECT * FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDINSERT = "INSERT INTO BOARDS VALUES(?,?,?,?,?)";
	private final String BOARDDELETE = "DELETE FROM BOARDS WHERE BOARD_NO = ?";
	private final String BOARDUPDATE = "UPDATE BOARDS SET TITLE=?, CONTENT=? WHERE BOARD_NO=?";
	
	public ArrayList<BoardVO> selectList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(BOARDSELECTLIST);
			rs = psmt.executeQuery(); //이 구문이 DB의 record set(자바에서는 =ResultSet)을 리턴함
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
				list.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(); //안 닫아주면 커넥션 계속 일어남, 커넥션 계속 유지하다보면 DB죽음
		}
		return list;
	}
	
	public BoardVO select(BoardVO vo) {
		//한 개의 레코드 조회 구문 작성
		try {
			psmt = conn.prepareStatement(BOARDSELECT);
			psmt.setInt(1, vo.getBoardNo()); //첫번째 ?에 int형태의 vo의 getBoardNo 값을 넣음
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreationDate(rs.getDate("creation_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	
	public int insert(BoardVO vo) {
		int n=0;
		//여기에 입력작업을 쓴다.
		try {
			psmt = conn.prepareStatement(BOARDINSERT);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setDate(5, vo.getCreationDate());
			n = psmt.executeUpdate(); //실행되면 n= 1이 됨
			//select는 executeQuery()임 나머지는 executeUpdate()
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(BoardVO vo) {
		int n=0;
		//여기에 수정작업을 쓴다.
		try {
			psmt = conn.prepareStatement(BOARDUPDATE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getBoardNo());
			n = psmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(BoardVO vo) {
		int n=0;
		//여기에 삭제작업을 쓴다.
		try {
			psmt = conn.prepareStatement(BOARDDELETE);
			psmt.setInt(1, vo.getBoardNo());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	private void close() { //close 열리는 순서 반대로 닫아줌...알자너? 안쪽부터 닫는거
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
