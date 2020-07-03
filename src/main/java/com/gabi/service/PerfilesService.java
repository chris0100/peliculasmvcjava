package com.gabi.service;

import com.gabi.model.Perfil;

public interface PerfilesService {

    void guardar(Perfil perfil);

    Perfil encontrarPerfil(String cuenta);

    void borrarCuenta(String cuenta);
}
