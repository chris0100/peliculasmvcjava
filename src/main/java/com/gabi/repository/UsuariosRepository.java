package com.gabi.repository;

import com.gabi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer> {

    Usuario findById(int id);

}
