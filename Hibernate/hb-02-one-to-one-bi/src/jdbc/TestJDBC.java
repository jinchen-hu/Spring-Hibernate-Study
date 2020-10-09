package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
			String user = "hbstudent";
			String password = "hbstudent";

			System.out.println("connecting to database: " + jdbcUrl);

			Connection myConnection = DriverManager.getConnection(jdbcUrl, user, password);

			System.out.println("connected successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
