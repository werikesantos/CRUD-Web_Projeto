package br.com.cadastroalunos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/db_aluno?userTimezone=trueserverTimezone=UTFC";
	final static String USER = "root";
	final static String PASSWORD = "#MySQL@2020#";
	
	public static Connection getConnection() throws SQLException{//LAN�AR EXCEPTION
	
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL, USER, PASSWORD);	
	}
	
}
