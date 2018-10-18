package br.com.flf.jdbc;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexao {
	private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost/Acervo";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
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