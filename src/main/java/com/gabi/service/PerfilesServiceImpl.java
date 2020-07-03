package com.gabi.service;

import com.gabi.model.Perfil;
import com.gabi.repository.PerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilesServiceImpl implements PerfilesService {

    @Autowired
    PerfilesRepository perfilesRepositoryObj;

    public void guardar(Perfil perfil) {
        perfilesRepositoryObj.save(perfil);
    }

    public Perfil encontrarPerfil(String cuenta) {
        return perfilesRepositoryObj.findByCuenta(cuenta);
    }

    public void borrarCuenta(String cuenta) {
        perfilesRepositoryObj.deleteByCuenta(cuenta);
    }
}
