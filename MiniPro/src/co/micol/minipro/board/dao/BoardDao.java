package co.micol.minipro.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;
import co.micol.minipro.board.service.BoardVo;

public class BoardDao extends DAO implements DbInterface<BoardVo> {
	//DAO = Date Access Object
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public ArrayList<BoardVo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo select(BoardVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
