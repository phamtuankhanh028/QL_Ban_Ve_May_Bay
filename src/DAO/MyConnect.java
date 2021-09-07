package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {

	private static Connection kn;
	
	public static Connection getKn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbanvemb?useUnicode=true&characterEncoding=UTF-8";
			kn = DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kn;
	}
}
