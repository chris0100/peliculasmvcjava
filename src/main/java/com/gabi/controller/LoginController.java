package com.gabi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping("/index")
    public String mostrarPrincipalAdmin(Authentication authentication){
        System.out.println(authentication.getName());

        for(GrantedAuthority g : authentication.getAuthorities()){
            System.out.println("rol: " + g.getAuthority());
        }
        return "admin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request,null,null);
        return "redirect:/formLogin";
    }

}
