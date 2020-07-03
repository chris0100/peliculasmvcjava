package com.gabi.controller;

import com.gabi.model.Banner;
import com.gabi.service.BannerService;
import com.gabi.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/banners")
public class BannerController {

    @Autowired
    BannerService bannerServiceObj;

    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Banner> banners = bannerServiceObj.buscarTodos();
        model.addAttribute("banners",banners);
        return "banners/listBanners";
    }


    @GetMapping("/create")
    public String crear(){
        return "banners/formBanner";
    }


    @PostMapping("/save")
    public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen")MultipartFile multipart, HttpServletRequest request){
        System.out.println(banner.getArchivo());
        System.out.println(multipart.getName());
        if(result.hasErrors()){
            System.out.println("hay errores");

            return "banners/formBanner";
        }

        if(!multipart.isEmpty()){
            String nombreImagen = Utileria.guardarImagen(multipart,request);
            banner.setArchivo(nombreImagen);
        }

        bannerServiceObj.insertar(banner);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/banners/index";
    }
}
