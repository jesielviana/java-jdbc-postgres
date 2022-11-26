package com.example.visao;

import java.util.List;

import com.example.dao.UsuarioDao;
import com.example.entidades.Usuario;

public class UsuarioForm {

    public void cadastraUsuario(){
        Usuario usuario = new Usuario("Jesiel"); // input
        new UsuarioDao().salvar(usuario); // btn salvar
    }

    public void listarUsuarios(){
        List<Usuario> usuariosEncontrados = new UsuarioDao().consultarTodos();
        System.out.println("Quantidade de usuários: " + usuariosEncontrados.size());
        for(int i = 0; i < usuariosEncontrados.size(); i++){
            System.out.println(usuariosEncontrados.get(i).getId() + " - " + usuariosEncontrados.get(i).getNome());
        }
    }
    
}
