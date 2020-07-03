package com.gabi.controller;

import com.gabi.model.Horario;
import com.gabi.model.Noticia;
import com.gabi.model.Pelicula;
import com.gabi.service.BannerService;
import com.gabi.service.HorarioService;
import com.gabi.service.NoticiasService;
import com.gabi.service.PeliculasService;
import com.gabi.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //formato para usar en fechas

	@Autowired
	private PeliculasService peliculasServiceObj;

	@Autowired
	private BannerService bannerServiceOj;

	@Autowired
	private NoticiasService noticiaServiceObj;

	@Autowired
	private HorarioService horarioServiceObj;



	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){

		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas =  peliculasServiceObj.buscarTodas();
		List<Noticia> listaNoticias = noticiaServiceObj.mostrarTodas();

		model.addAttribute("listaFechas",listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners",bannerServiceOj.buscarTodos());
		model.addAttribute("noticias", listaNoticias);

		System.out.println("fecha es:"+ fecha);

		return "home";
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = peliculasServiceObj.buscarTodas();
		List<Noticia> listaNoticias = noticiaServiceObj.mostrarTodas();


		model.addAttribute("listaFechas",listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners",bannerServiceOj.buscarTodos());
		model.addAttribute("noticias", listaNoticias);
		return "home";
	}



     @RequestMapping(value = "/detail/{id}/{fechaBusqueda}", method = RequestMethod.GET) //usa a pathvariable
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaBusqueda") Date fechaBusqueda) {
//    @RequestMapping(value = "/detail", method = RequestMethod.GET) //usa a requestparam
//	public String mostrarDetalle(Model model, @RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fechaBusqueda) {
		model.addAttribute("pelicula", peliculasServiceObj.buscarPorId(idPelicula));
		model.addAttribute("fechaBusqueda", dateFormat.format(fechaBusqueda));

		List<Horario> listaHorariosQuery = horarioServiceObj.buscarPorIdPelicula(idPelicula,fechaBusqueda);
         System.out.println(listaHorariosQuery.size() + ": " + listaHorariosQuery);
		model.addAttribute("horarios",listaHorariosQuery);

		return "detalle";
	}



	//personalizar el data bind para el formato de fecha
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}


	@GetMapping("/formLogin")
	public String mostrarLogin(){
		return "formLogin";
	}






}
