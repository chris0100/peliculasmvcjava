package com.gabi.controller;

import com.gabi.model.Contacto;
import com.gabi.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ContactoController {

    @Autowired
    PeliculasService peliculasServiceObj;

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute("contacto") Contacto contacto, Model model){
        List<String> listaGeneros = peliculasServiceObj.buscarGeneros();
        model.addAttribute("listaGeneros", listaGeneros);
        model.addAttribute("tipoNotificaciones", tipoNotificaciones());
        return "formContacto";
    }

    @PostMapping("/contacto")
    public String guardar(@ModelAttribute("contacto") Contacto contacto){
        System.out.println(contacto);
        return "redirect:/contacto";
    }

    private List<String> tipoNotificaciones(){
        List<String> tipos = new LinkedList<String>();
        tipos.add("Estrenos");
        tipos.add("Promociones");
        tipos.add("Noticias");
        tipos.add("Preventas");
        return tipos;
    }

}
