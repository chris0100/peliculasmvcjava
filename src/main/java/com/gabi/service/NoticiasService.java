package com.gabi.service;

import com.gabi.model.Noticia;

import java.util.List;

public interface NoticiasService {

    void guardar(Noticia noticia);

    List<Noticia> mostrarTodas();
}
