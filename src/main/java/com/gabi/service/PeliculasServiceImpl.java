package com.gabi.service;

import com.gabi.model.Pelicula;
import com.gabi.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PeliculasServiceImpl implements PeliculasService {

    private List<Pelicula> lista = null;

    @Autowired
    private PeliculaRepository peliculaRepositoryObj;


    public PeliculasServiceImpl(){
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    }


    public List<Pelicula> buscarTodas() {
        return peliculaRepositoryObj.findAll();
    }


    public Pelicula buscarPorId(int idPelicula) {
        return peliculaRepositoryObj.findById(idPelicula);
    }


    public void insertar(Pelicula pelicula) {
        peliculaRepositoryObj.save(pelicula);
    }

    public void eliminar(int idPelicula) {
        peliculaRepositoryObj.deleteById(idPelicula);
    }

    public List<String> buscarGeneros() {
        List<String> listaGeneros = new LinkedList<String>();
        listaGeneros.add("Accion");
        listaGeneros.add("Aventura");
        listaGeneros.add("Clasicas");
        listaGeneros.add("Comedia Romantica");
        listaGeneros.add("Drama");
        listaGeneros.add("Terror");
        listaGeneros.add("Infantil");
        listaGeneros.add("Accion y Aventura");
        listaGeneros.add("Romantica");
        listaGeneros.add("Ciencia Ficcion");

        return listaGeneros;
    }
}
