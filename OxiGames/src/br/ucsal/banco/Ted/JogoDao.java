package br.ucsal.banco.Ted;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDao {

	private Connection connection;

	public JogoDao() {
		this.connection = Conexao.connect();
	}

	public void adicionar(Jogo jogo) {
		String sql = "insert into jogo " + "(Id_jogo,nome,Id_genero,Id_nota,descricao,data)" + " values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, jogo.getId_jogo());
			stmt.setString(2, jogo.getNome());
			stmt.setString(3, jogo.getGenero());
			stmt.setDouble(4, jogo.getNota());
			stmt.setString(5, jogo.getDescricao());
			stmt.setDate(6, (Date) jogo.getData());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from produto where id_acai=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Jogo jogo) {
		String sql = "update produto set Id_jogo=?, nome=? ,Id_genero=? ,Id_nota=?,descricao=?, data_lancamento  where id_jogo=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, jogo.getId_jogo());
			stmt.setString(2, jogo.getNome());
			stmt.setString(3, jogo.getGenero());
			stmt.setDouble(4, jogo.getNota());
			stmt.setString(5, jogo.getDescricao());
			stmt.setDate(6, (Date) jogo.getData());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Jogo> getLista() {

		try {
			List<Jogo> jogos = new ArrayList<Jogo>();
			String sql = "select * from jogo";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Jogo jogo = new Jogo();
				jogo.setId_jogo(rs.getInt("id_jogo"));
				jogo.setNome(rs.getString("nome"));
				jogo.setGenero(rs.getString("Id_genero"));
				jogo.setNota(rs.getInt("Id_nota"));
				jogo.setDescricao(rs.getString("descricao"));
				jogo.setData(rs.getDate("data_lancameto"));
				jogos.add(jogo);
			}
			rs.close();
			stmt.close();
			return jogos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Jogo getJogo(Long id) {
		String sql = "select * from jogo where id_jogo=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Jogo jogo = new Jogo();
				jogo.setId_jogo(rs.getInt("id_jogo"));
				jogo.setNome(rs.getString("nome"));
				jogo.setGenero(rs.getString("Id_genero"));
				jogo.setNota(rs.getInt("Id_nota"));
				jogo.setDescricao(rs.getString("descricao"));
				jogo.setData(rs.getDate("data_lancameto"));
				return jogo;
			}
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}
