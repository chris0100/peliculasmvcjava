package com.gabi.service;

import com.gabi.model.Pelicula;

import java.util.List;

public interface PeliculasService {
    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int idPelicula);

    void insertar(Pelicula pelicula);

    List<String> buscarGeneros();

    void eliminar(int idPelicula);
}
