package com.impl.repository;

import java.sql.Connection;
import java.sql.DriverManager;

//Bruno Monteiro -- 18/08/2014

public class Conexao {
	
	private static String usuario = "root";
	private static String senha = "abcd1234";
	private static String banco = "ExtremeExploration";
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
