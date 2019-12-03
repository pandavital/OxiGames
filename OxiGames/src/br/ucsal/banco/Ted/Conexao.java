package br.ucsal.banco.Ted;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class Conexao {

	private final static String url = "jdbc:postgresql://localhost/oxigames";
	private final static String user = "postgres";
	private final static String password = "postegresql";

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
		Jogo jogo1 = new Jogo(1, "Mayro", 10, "Dating Sim", "JUMP" , new Date(10/10/98));
		Jogo jogo2 = new Jogo(2, "Shoot", 1, "FPS", "Massa" , new Date(11/11/01));
		Jogo jogo3 = new Jogo(3, "Kill", 5, "Adventure", "Brabo" , new Date(9/10/98));
		
		JogoDao.adicionar(jogo1);
		JogoDao.adicionar(jogo2);
		JogoDao.adicionar(jogo3);
		
		JogoDao.remove(jogo2.getId_jogo());
		
		Jogo jogo4 = new Jogo(3, "Kill", 5, "Adventure", "Ruim" , new Date(9/10/98));
		
		JogoDao.altera(jogo4);
		
		JogoDao.getJogo(1);
		
		JogoDao.getLista();

	}
	
}
