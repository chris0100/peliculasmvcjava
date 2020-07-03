package com.gabi.controller;

import com.gabi.model.Noticia;
import com.gabi.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

    @Autowired
    NoticiasService noticiasServiceObj;

    @GetMapping("/crear")
    public String crear(){
        return "noticias/formNoticias";
    }

    @PostMapping("/save")
    public String guardar(Noticia noticia){
        noticiasServiceObj.guardar(noticia);
        return "noticias/formNoticias";
    }
}


