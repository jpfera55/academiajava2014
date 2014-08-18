package com.impl.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static String usuario = "root";
	private static String senha = "123";
	private static String banco = "";
	private static String driveName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/" + banco;
	
	public static Connection getConexao(){
		try {
			Connection con;
			Class.forName(driveName);
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conectado!");
			return con;
		} catch (Exception e) {
			System.out.println("Erro ao conectar no banco!");
			return null;
		}
	}
}
