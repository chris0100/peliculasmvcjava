package com.gabi.repository;

import com.gabi.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilesRepository extends JpaRepository<Perfil,Integer> {

    Perfil findByCuenta(String cuenta);

    void deleteByCuenta(String cuenta);

}
