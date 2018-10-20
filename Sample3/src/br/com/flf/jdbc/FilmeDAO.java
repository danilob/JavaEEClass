package br.com.flf.jdbc;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;


import br.com.flf.models.Filme;

public class FilmeDAO {
	
	public void adiciona(Filme novo) throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       

		String sql = "insert into filme " +
				"(titulo,genero,duracao,imdb,lancamento)" +
				" values (?,?,?,?,?)";
		try {
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,novo.getTitulo());
			stmt.setString(2,novo.getGenero());
			stmt.setInt(3,novo.getDuracao());
			stmt.setFloat(4, novo.getIMDb());
			stmt.setDate(5,new java.sql.Date(novo.getLancamento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		conx.close(conn);

	}

	public List<Filme> getFilmes() throws Exception {
		Conexao conx = new Conexao();
		Connection conn = conx.abrir();       
		List<Filme> filmes = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("select * from filme");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			String titulo = rs.getString("titulo");
			String genero = rs.getString("genero");
			Calendar data = null;
			//String lancamento = rs.getDate(columnIndex)("lancamento");
			//Date date_lanc = (Date) new	 SimpleDateFormat("dd/mm/yyyy").parse(rs.getString("lancamento"));
			//System.out.println(rs.getString("lancamento"));
			data = Calendar.getInstance();
			data.setTime(rs.getDate("lancamento"));
			int duracao = rs.getInt("duracao");
			float imdb = rs.getFloat("imdb");
			long id = rs.getLong("id");
			Filme row = new Filme(titulo,genero,data,duracao,imdb);
			row.setId(id);
			filmes.add(row);
		}
		
		stmt.close();
		conn.close();
		return filmes;
	}

	public List<Filme> getPesquisa(String key){
		List<Filme> filmes = new ArrayList<>();
		Conexao conx = new Conexao();
		Connection conn;
		try {
			conn = conx.abrir();
		       
		PreparedStatement stmt = conn.prepareStatement("select * from filme where titulo like ?");
		stmt.setString(1,key);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()){
			String titulo = rs.getString("titulo");
			String genero = rs.getString("genero");
			Calendar data = null;
			data = Calendar.getInstance();
			data.setTime(rs.getDate("lancamento"));
			int duracao = rs.getInt("duracao");
			float imdb = rs.getFloat("imdb");
			long id = rs.getLong("id");
			Filme row = new Filme(titulo,genero,data,duracao,imdb);
			row.setId(id);
			filmes.add(row);
		}
		
		stmt.close();
		conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmes;
	}
}
