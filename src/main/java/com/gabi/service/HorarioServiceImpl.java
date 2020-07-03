package com.gabi.service;

import com.gabi.model.Horario;
import com.gabi.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    HorarioRepository horarioRepositoryObj;



    public void guardar(Horario horario) {
        horarioRepositoryObj.save(horario);
    }


    public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
        System.out.println("la fecha de busqueda es : " + fecha + " y el id de la pelicula es: " + idPelicula);
        List<Horario> listaHorarioEncontrados =  horarioRepositoryObj.findByPelicula_IdAndFecha(idPelicula,fecha);
        return listaHorarioEncontrados;
    }
}
