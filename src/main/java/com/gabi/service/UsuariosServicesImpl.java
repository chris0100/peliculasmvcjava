package com.gabi.service;

import com.gabi.model.Usuario;
import com.gabi.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepositoryObj;

    public void guardar(Usuario usuario) {
        usuariosRepositoryObj.save(usuario);
    }

    public List<Usuario> mostrarUsuarios() {
        return usuariosRepositoryObj.findAll();
    }

    public void eliminar(int id) {
        usuariosRepositoryObj.deleteById(id);
    }

    public String cuentaUsuario(int id){
        Usuario usuarioEncontrado = usuariosRepositoryObj.findById(id);
        return usuarioEncontrado.getCuenta();
    }

    public Usuario mostrarUsuario(int id) {
        return usuariosRepositoryObj.findById(id);
    }
}
