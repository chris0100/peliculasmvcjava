package com.gabi.service;

import com.gabi.model.Usuario;

import java.util.List;

public interface UsuariosService {

    void guardar(Usuario usuario);

    List<Usuario> mostrarUsuarios();

    void eliminar(int id);

    String cuentaUsuario(int id);

    Usuario mostrarUsuario(int id);
}
