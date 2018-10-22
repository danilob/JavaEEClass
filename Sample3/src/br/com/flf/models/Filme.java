package br.com.flf.models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Filme {
	long Id;
	String titulo;
	String genero;
	Calendar lancamento;
	int duracao;
	float IMDb;

	public Filme() {}
	public Filme(String titulo, String genero, Calendar lancamento, int duracao, float iMDb) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.lancamento = lancamento;
		this.duracao = duracao;
		this.IMDb = iMDb;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Calendar getLancamento() {
		return lancamento;
	}
	public void setLancamento(Calendar lancamento) {
		this.lancamento = lancamento;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public float getIMDb() {
		return IMDb;
	}
	public void setIMDb(float iMDb) {
		IMDb = iMDb;
	}

	public String getLancamentoDate() {
		Calendar calendar = this.lancamento;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(calendar.getTime());

	}

	public static void main(String[] args) {


	}


}
