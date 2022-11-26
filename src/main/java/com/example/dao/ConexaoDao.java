package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    public static Connection getConexao(){
        try {
            Connection conexcao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_aula",
            "postgres", "12345");
            return conexcao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    } 
}
