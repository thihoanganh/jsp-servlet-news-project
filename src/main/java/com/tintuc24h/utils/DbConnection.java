package com.tintuc24h.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DbConnection {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://ec2-3-224-251-47.compute-1.amazonaws.com:5432/d8au3t4sv25a12?user=ccokvxsuvtbvuj&password=7ac9a05d673006c7d77dde9b3748907d97a694d277cd915d3bfee7c0b959c85d";
			//String url = "jdbc:postgresql://localhost:5432/news_db?user=postgres&password=123456";
			return  DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 return null;
		}
	

	}
}
