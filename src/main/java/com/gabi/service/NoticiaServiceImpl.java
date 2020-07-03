package com.gabi.service;

import com.gabi.model.Noticia;
import com.gabi.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticiaServiceImpl implements NoticiasService {

    @Autowired
    NoticiasRepository noticiasRepositoryObj;

    public NoticiaServiceImpl(){

    }



    public void guardar(Noticia noticia) {
        noticiasRepositoryObj.save(noticia);
    }

    public List<Noticia> mostrarTodas() {
        return noticiasRepositoryObj.findAll();
    }
}
