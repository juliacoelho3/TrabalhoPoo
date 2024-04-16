package db;


import java.sql.Connection;
import java.sql.DriverManager;	
import java.sql.SQLException;

public class ConnectionFactory {
	String url = "jdbc:postgresql://localhost:5432/trabalho";
	String usuario = "postgres";
	String senha = "123456";
	
	Connection connection;
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			System.out.println("Driver não conectado");
			return null;
		}
		return connection;
	}
}
