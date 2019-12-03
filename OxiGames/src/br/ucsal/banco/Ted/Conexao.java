package br.ucsal.banco.Ted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private final static String url = "jdbc:postgresql://localhost/oxigames";
	private final static String user = "postgres";
	private final static String password = "pgadmin";

	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}

	public static void main(String[] args) {
		Conexao.connect();
	}
}
