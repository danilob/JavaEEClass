package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
	private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/Acervo";
    private static final String DRIVER = "org.postgresql.Driver";
    public Connection abrir() throws Exception {
        Class.forName(DRIVER);  // Registrar o driver
        // Capturar a conexão
        Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn; // Retorna a conexao aberta
    }
    public void close(Connection conn) throws Exception {
        conn.close();
    }

}
/** Criação do banco de dados!**/