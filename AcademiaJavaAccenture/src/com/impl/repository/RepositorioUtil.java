package com.impl.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioUtil {
	
	public static int retornarChavePrimariaInserida(ResultSet rs){
		try {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
