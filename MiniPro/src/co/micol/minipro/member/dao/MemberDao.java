package co.micol.minipro.member.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.minipro.common.DAO;
import co.micol.minipro.common.DbInterface;
import co.micol.minipro.common.EmployeeVO;
import co.micol.minipro.member.service.MemberVo;
import oracle.jdbc.OracleTypes;

public class MemberDao extends DAO implements DbInterface<MemberVo> {
	
	private PreparedStatement psmt;
	private ResultSet rs;

	//210217 프로시져 연습
	public EmployeeVO getSalaryInfo(int empId, int salary) {
		EmployeeVO resultvo = null;
		try {
			CallableStatement csmt = conn.prepareCall("{ call SAL_HISTORY_PROC(?,?,?) }"); // ?
			csmt.setInt(1, empId);
			csmt.setInt(2, salary);
			csmt.registerOutParameter(3, OracleTypes.CURSOR); //out변수타입 프로시저꺼 받아옴
			csmt.execute();
			
			//프로시저 실행한거 다시 받아오기
			rs = (ResultSet) csmt.getObject(3);
			if(rs.next()) {
				resultvo = new EmployeeVO();
				resultvo.setEmail(rs.getString("email"));
				resultvo.setEmployeeId(rs.getInt("employee_id"));
				resultvo.setFirstName(rs.getString("first_name"));
				resultvo.setHireDate(rs.getString("hire_date"));
				resultvo.setLastName(rs.getString("last_name"));
				resultvo.setSalary(rs.getInt("salary"));
				System.out.println(rs.getInt(1)); //결과값의 1번째 콜름 = employee_id
				System.out.println(rs.getString("first_name")); //이렇게 해도됨
				System.out.println(rs.getInt("salary")); //사실 getInt, getString 아무거나 해도 상관없음(출력타입만 이거로 설정이라)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return resultvo;
	}
	
	//210217 paging연습
	public List<EmployeeVO> getPagingList(int page){
		List<EmployeeVO> list = new ArrayList<>();
		String sql = "select b.* from"//
				+ " (select rownum rn, a.* from"//
				+ " (select e.* from employees e order by e.employee_id"//
				+ " ) a) b where b.rn between ? and ?";
		try {
			psmt = conn.prepareStatement(sql);
			int startCnt = 1+(page-1)*10;
			int endCnt = page*10; 
			psmt.setInt(1, startCnt);
			psmt.setInt(2, endCnt);
			rs = psmt.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmail(rs.getString("email"));
				vo.setEmployeeId(rs.getInt("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getInt("salary"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public int getTotalCnt() {
		String sql = "select count(*) from employees";
		int totalCnt=0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return totalCnt;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public ArrayList<MemberVo> selectList() {
		// 회원전체정보 출력
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM member";
		MemberVo vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setmId(rs.getString("mid"));
				vo.setmId(rs.getString("mname"));
				vo.setmId(rs.getString("mauth"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public MemberVo select(MemberVo vo) {
		// 한명의 레코드를 찾아오는 메소드
		String sql = "SELECT * FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mname")); //여기는 DB의 파라미터명 적어야함
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insert(MemberVo vo) {
		// 회원가입 메소드
		String sql = "INSERT INTO member(mid, mname, mpassword) VALUES(?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int update(MemberVo vo) {
		// 권한과 패스워드만 변경하는 메소드(이름,아이디는 변경X)
		// 지금은 변경하는 콜름이 적어서 이렇게 하지만 콜름수가 많아지면 
		// 걍 테이블 통째로 값 받아서 업데이트하는게 더 코딩하기 쉽다. 
		int n = 0;
		String sql = null;
		if(vo.getmPassword() != null) {
			sql = "UPDATE member SET mpassword = ? WHERE mid = ?";
		}else if(vo.getmAuth() != null) {
			sql = "UPDATE member SET mauth = ? WHERE mid = ?";
		}
		try {
			psmt = conn.prepareStatement(sql);
			if(vo.getmPassword() != null) {
				psmt.setString(1, vo.getmPassword());
				psmt.setString(2, vo.getmId());
			}else if(vo.getmAuth() != null) {
				psmt.setString(1, vo.getmAuth());
				psmt.setString(2, vo.getmId());
			}
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int delete(MemberVo vo) {
		// 회원 삭제 메소드
		int n = 0;
		String sql = "DELETE FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public boolean isIdCheck(String id) {
		//id 중복체크 메소드
		boolean bool = true; //기본 false
		String sql = "SELECT mid FROM member WHERE mid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id); //입력한 id값 넣어서 select
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bool;
	}
	
	public MemberVo login(MemberVo vo) {
		// 로그인 메소드
		String sql = "SELECT * FROM member WHERE mid = ? AND mpassword = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setmName(rs.getString("mname")); //여기는 DB의 파라미터명 적어야함
				vo.setmAuth(rs.getString("mauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
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
