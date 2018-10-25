package br.com.flf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/Acervo";
    private static final String DRIVER = "org.postgresql.Driver";
    //para mysql
	//private static final String USUARIO = "root";
    //private static final String SENHA = "root";
    //private static final String URL = "jdbc:mysql://localhost/Acervo";
    //private static final String DRIVER = "com.mysql.jdbc.Driver";
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
/*
create database Acervo
create table filme (
        id bigserial primary key,
        titulo VARCHAR(400),
        genero VARCHAR(200),
        lancamento DATE,
        duracao integer,
        imdb real
    );
*/
