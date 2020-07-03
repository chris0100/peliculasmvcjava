package com.gabi.repository;

import com.gabi.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia,Integer> {

    //select * from Noticia where estatus = ? and id = ?
    Noticia findByEstatusAndId(String estatus, int id);

    //select * from Noticia where id = ?
    Noticia findById(int id);

    //select * from Noticia where estatus = ? or id = ?
    List<Noticia> findByEstatusOrId(String estatus, int id);

    //where fecha betweem ? and ?
    List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);


}
