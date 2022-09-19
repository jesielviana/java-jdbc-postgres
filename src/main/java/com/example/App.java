package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Connection conexcao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_aula",
                    "postgres", "");
            if (conexcao != null) {
                System.out.println("Banco de dados conectado com sucesso!");
                Statement stm = conexcao.createStatement();
                insereDados(stm);
                consultaDados(stm);
                conexcao.close();
            } else {
                System.out.println("Conexão falhou!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void consultaDados(Statement stm) {
        String sql = "select id, nome from usuario";
        try {
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                System.out.println("id: " + result.getInt("id") + ", Nome: " + result.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insereDados(Statement stm) {
        String sql = "insert into usuario (nome) values ('Silva')";
        try {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
