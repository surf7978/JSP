package co.micol.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String password = "1234";
	
	public Connection conn;
	
	public DAO() {
		try {
			Class.forName(driver);//이렇게 해야 Class에있는 드라이브 가져옴
			conn = DriverManager.getConnection(url, user, password); //어떤 url, 계정으로 할지 결정
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
