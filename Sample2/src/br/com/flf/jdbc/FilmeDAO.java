package br.com.flf.jdbc;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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

}
