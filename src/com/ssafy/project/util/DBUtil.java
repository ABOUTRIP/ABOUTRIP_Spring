package com.ssafy.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://70.12.60.84:3306/enjoytrip?serverTimezone=UTC";
	private final String USER = "ssafy";
	private final String PASSWORD = "ssafy";
	private static DBUtil instance = new DBUtil();
	
	private DBUtil() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql Driver Load 실패!!!");
		}
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public void close(AutoCloseable... autoCloseables ) {
		for(AutoCloseable c: autoCloseables) {
				try {
					if(c!=null) c.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
