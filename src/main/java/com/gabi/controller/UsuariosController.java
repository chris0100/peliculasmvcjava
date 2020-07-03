package com.gabi.controller;

import com.gabi.model.Perfil;
import com.gabi.model.Usuario;
import com.gabi.service.PerfilesService;
import com.gabi.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UsuariosService usuariosServiceObj;

    @Autowired
    private PerfilesService perfilesServiceObj;


    @GetMapping("/index")
    public String indexado(Model model){
        List<Usuario> listaUsuarios = usuariosServiceObj.mostrarUsuarios();
        for(Usuario usuarioObj : listaUsuarios){
                String perfil = perfilesServiceObj.encontrarPerfil(usuarioObj.getCuenta()).getPerfil();
                usuarioObj.setPerfil(perfil);
                System.out.println(perfil);
        }
        model.addAttribute("usuarios", listaUsuarios);
        return "usuarios/listUsuarios";
    }


    @GetMapping("/create")
    public String crear(@ModelAttribute("usuario") Usuario usuario){
        return "usuarios/formUsuario";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil){

        Perfil perfilToSave = perfilesServiceObj.encontrarPerfil(usuario.getCuenta());

        if(perfilToSave == null){
            perfilToSave = new Perfil();
        }
        perfilToSave.setCuenta(usuario.getCuenta());
        perfilToSave.setPerfil(perfil);

        String passwordFinal = encoder.encode(usuario.getPwd());
        usuario.setPwd(passwordFinal);
        usuario.setActivo(1);
        usuariosServiceObj.guardar(usuario);

        perfilesServiceObj.guardar(perfilToSave);

        return "redirect:/usuarios/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        String cuenta = usuariosServiceObj.cuentaUsuario(id);
        System.out.println("esta es la cuenta a borrar: " + cuenta);
        usuariosServiceObj.eliminar(id);
        perfilesServiceObj.borrarCuenta(cuenta);

        return "redirect:/usuarios/index";
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        Usuario usuarioToEdit = usuariosServiceObj.mostrarUsuario(id);
        model.addAttribute("usuario", usuarioToEdit);
        return "usuarios/formUsuario";
    }


    @GetMapping("/demo-bcrypt")
    public String pruebaCrypt(){
        String password = "mari123";
        String encriptado = encoder.encode(password);
        System.out.println("password encriptado: " + encriptado);
        return "usuarios/demo";
    }

}
