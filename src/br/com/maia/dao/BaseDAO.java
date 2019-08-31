package br.com.maia.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	public BaseDAO() {
		// class JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection connection() throws SQLException {
		// URL de conexão
		String url = "jdbc:mysql://localhost/carros";

		// conect
		Connection conn = DriverManager.getConnection(url, "root", "2522");
		return conn;

	}
	/*
	//testando conexão
	 public static void main(String[] args) throws SQLException {
		BaseDAO db = new BaseDAO();
		
		Connection cn = db.connection();
		System.out.println(cn);
	}
*/
}
