package com.gabi.service;

import com.gabi.model.Horario;

import java.util.Date;
import java.util.List;


public interface HorarioService {

    void guardar(Horario horario);

    //select * from horario where idpelicula='2' and fecha='28-04-2020'
    List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
}
