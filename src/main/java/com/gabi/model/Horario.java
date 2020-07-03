package com.gabi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private String hora;
    private String sala;
    private double precio;

    //@Transientid
    @ManyToOne  //muchos horarios para una pelicula
    @JoinColumn(name = "idpelicula")
    private Pelicula pelicula;

    public Horario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", sala='" + sala + '\'' +
                ", precio=" + precio +
                ", pelicula=" + pelicula +
                '}';
    }
}
