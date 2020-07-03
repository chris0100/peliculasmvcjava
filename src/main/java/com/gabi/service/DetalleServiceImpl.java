package com.gabi.service;

import com.gabi.model.Detalle;
import com.gabi.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl implements DetalleService {

    @Autowired
    private DetalleRepository detalleRepositoryObj;

    public void insertar(Detalle detalle) {
        detalleRepositoryObj.save(detalle);
    }

    public void eliminar(int idDetalle) {
        detalleRepositoryObj.deleteById(idDetalle);
    }
}
