package com.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.entidades.Usuario;

public class UsuarioDao {

    Connection conexao;

    public UsuarioDao(){
        conexao = ConexaoDao.getConexao();
    }
    
    public void salvar(Usuario usuario){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into usuarios (nome) values ('"+usuario.getNome()+"')";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Usuario> consultarTodos(){
        String sql = "select id, nome from usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                usuarios.add(new Usuario(result.getLong("id"), result.getString("nome")));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
