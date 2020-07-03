package com.gabi.controller;

import com.gabi.model.Pelicula;
import com.gabi.service.DetalleService;
import com.gabi.service.PeliculasService;
import com.gabi.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {


    @Autowired
    private PeliculasService peliculasServiceObj;

    @Autowired
    private DetalleService detalleServiceObj;


    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Pelicula> listaPeliculas = peliculasServiceObj.buscarTodas();
        model.addAttribute("peliculas",listaPeliculas);
        return "peliculas/listPeliculas";
    }



    @GetMapping("/create")
    public String crear(@ModelAttribute("pelicula") Pelicula pelicula, Model model){
        generadorGeneros(model);
        return "peliculas/formPelicula";
    }


    @PostMapping("/save")
    public String guardar(@ModelAttribute("pelicula") Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen")MultipartFile multipart, HttpServletRequest request, Model model){

        //si encuentra algun error, redirecciona
        if(result.hasErrors()){
            generadorGeneros(model);
            return "peliculas/formPelicula";
        }

        if(!multipart.isEmpty()){
            String nombreImagen = Utileria.guardarImagen(multipart,request);
            pelicula.setImagen(nombreImagen);
        }

        detalleServiceObj.insertar(pelicula.getDetalle());
        peliculasServiceObj.insertar(pelicula);

        attributes.addFlashAttribute("mensaje", "El registro fue guardado");

        return "redirect:/peliculas/index";
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        generadorGeneros(model);

        Pelicula peliculaToEdit = peliculasServiceObj.buscarPorId(id);
        model.addAttribute("pelicula",peliculaToEdit);
        System.out.println("esta es la pelicula que se va a editar:" + peliculaToEdit);
        return "peliculas/formPelicula";
    }



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes){
        int idDetalleToEliminar = peliculasServiceObj.buscarPorId(id).getDetalle().getId(); //encuentra en id de detalle a eliminar
        peliculasServiceObj.eliminar(id); //elimina la pelicula seleccionada
        detalleServiceObj.eliminar(idDetalleToEliminar); //elimina el detalle asociado a la pelicula
        attributes.addFlashAttribute("mensaje","El registro se ha eliminado satisfactoriamente");
        return "redirect:/peliculas/index";
    }




    //genera lista de generos
    public void generadorGeneros(Model model){
        List<String> listaGeneros = peliculasServiceObj.buscarGeneros();
        model.addAttribute("listaGeneros", listaGeneros);
    }





    //personalizar el data bind para el formato de fecha
    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
