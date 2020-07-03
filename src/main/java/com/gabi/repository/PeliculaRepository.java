package com.gabi.repository;

import com.gabi.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {


    Pelicula findById(int id);


}
