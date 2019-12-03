package br.ucsal.banco.Ted;

import java.util.Date;

public class Jogo {

	private Integer id_jogo;
	private String nome;
	private Integer Id_nota;
	private String Id_genero;
	private String descricao;
	private Date data_lancamento;


	public Jogo(Integer id_jogo, String nome, Integer nota, String genero, String descricao, Date data) {
		super();
		this.id_jogo = id_jogo;
		this.nome = nome;
		this.Id_nota = nota;
		this.Id_genero = genero;
		this.descricao = descricao;
		this.data_lancamento = data;
	}



	public Jogo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId_jogo() {
		return id_jogo;
	}

	public void setId_jogo(Integer id_jogo) {
		this.id_jogo = id_jogo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNota() {
		return Id_nota;
	}

	public void setNota(Integer nota) {
		this.Id_nota = nota;
	}

	public String getGenero() {
		return Id_genero;
	}

	public void setGenero(String genero) {
		this.Id_genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data_lancamento;
	}

	public void setData(Date data) {
		this.data_lancamento = data;
	}

	@Override
	public String toString() {
		return "Jogo [id_jogo=" + id_jogo + ", nome=" + nome + ", nota=" + Id_nota + ", genero=" + Id_genero
				+ ", descricao=" + descricao + ", data=" + data_lancamento + "]";
	}

}
