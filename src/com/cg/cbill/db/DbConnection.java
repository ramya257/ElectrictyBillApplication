package com.cg.cbill.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	public final static String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
	public final static String DB_URL="jdbc:oracle:thin:@localhost:1521:";
	public final static String DB_USERNAME="dbusername";
	public final static String DB_PASSWORD="dbpassword";

	
	public static Connection getConnection(){
		Connection conn= null;
		try {
			Class.forName(DB_DRIVER);
			conn=DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
