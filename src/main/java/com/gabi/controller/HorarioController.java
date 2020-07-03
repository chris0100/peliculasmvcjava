package com.gabi.controller;

import com.gabi.model.Horario;
import com.gabi.service.HorarioService;
import com.gabi.service.PeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired
    PeliculasService peliculasServiceObj;

    @Autowired
    HorarioService horarioServiceObj;


    @GetMapping("/create")
    public String crear(@ModelAttribute("horario") Horario horario, Model model){

        model.addAttribute("listaPeliculas",peliculasServiceObj.buscarTodas());
        return "horarios/formHorario";
    }


    @PostMapping("/save")
    public String guardar(@ModelAttribute("horario") Horario horario, BindingResult result,
                          Model model){
        if(result.hasErrors()){
            model.addAttribute("listaPeliculas",peliculasServiceObj.buscarTodas());
            System.out.println("hay errores");
            return "/horarios/formHorario";
        }

        System.out.println("el horario:" + horario);
        horarioServiceObj.guardar(horario);
        return "redirect:/horarios/create";
    }


    @InitBinder("horario")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


}
