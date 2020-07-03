package com.gabi.repository;

import com.gabi.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Integer> {

    List<Horario> findByPelicula_IdAndFecha(int id, Date fecha);

}
