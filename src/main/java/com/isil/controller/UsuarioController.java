package com.isil.controller;

import com.isil.service.IsilUserDetailsService;
import com.isil.service.PeliculaService;
import com.isil.service.TipoUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.isil.model.Usuario;
import com.isil.service.UsuarioService;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("SessionUser")
@RequestMapping("/")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final TipoUsuarioService tipoUsuarioService;
    private final PeliculaService peliculaService;
    private final IsilUserDetailsService isilUserDetailsService;

    public UsuarioController(UsuarioService usuarioService,
                             TipoUsuarioService tipoUsuarioService,
                             PeliculaService peliculaService, IsilUserDetailsService isilUserDetailsService) {
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
        this.peliculaService = peliculaService;
        this.isilUserDetailsService = isilUserDetailsService;
    }


    /* admin usuarios */
    @GetMapping("/admin/usuarios")
    public String usuarios(Model model) {
        usuarioService.findAll().ifPresent(usuarios -> model.addAttribute("usuarios", usuarios));
        return "admin/usuarios/index";
    }
//Registro desde admi
    @GetMapping("/admin/usuarios/add")
    public String usuariosAdd(Model model) {
        model.addAttribute("usuario", new Usuario());
        tipoUsuarioService.findAll().
                ifPresent(tipoUsuarios -> model.addAttribute("tipoUsuarios", tipoUsuarios));
        return "admin/usuarios/add";
    }

    @PostMapping("/admin/usuarios/save")
    public String usuariosSave(Usuario usuarioEdit) {
        usuarioService.saveOrUpdate(usuarioEdit);
        return "redirect:/admin/usuarios";
    }
    //Registro desde SoloEstrenos
    @PostMapping("/admin/usuariosFront/save")
    public String usuariosFrontSave(Usuario usuarioEdit) {
        usuarioService.saveOrUpdate(usuarioEdit);
        return "/index";
    }
    @GetMapping("/admin/usuariosFront/add")
    public String usuariosFrontAdd(Model model) {
        model.addAttribute("usuario", new Usuario());
        tipoUsuarioService.findAll().
                ifPresent(tipoUsuarios -> model.addAttribute("tipoUsuarios", tipoUsuarios));
        return "home/registro/index";
    }


    @GetMapping("/admin/usuarios/edit/{id}")
    public String usuariosEdit(@PathVariable Long id, Model model) {
        usuarioService.findById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));

        tipoUsuarioService.findAll().
                ifPresent(tipoUsuarios -> model.addAttribute("tipoUsuarios", tipoUsuarios));
        return "admin/usuarios/add";
    }

    @GetMapping("/admin/usuarios/delete/{id}")
    public String usuariosDelete(@PathVariable Long id, Model model) {
        usuarioService.deleteById(id);
        return "redirect:/admin/usuarios/index";
    }

    /* login */
/*    @GetMapping("/home/login")
    public String usuariosLogin(Model model) {
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        System.out.println(isilUserDetailsService.getTipoUsuario()+"13123");
        if(isilUserDetailsService.getTipoUsuario()==3) {
            return "/home/login/index";
        }
        else{
            return "redirect:/admin/usuarios";
        }


    }*/
    @GetMapping("/home/login")
    public String usuariosLogin(Model model, HttpSession session) {
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        //Variable de sesion
          Usuario su=usuarioService.findByCorreo(isilUserDetailsService.getCorreo());
          session.setAttribute("sessionUser",su);
        //Devolver home dependiendo del tipo de usuario
        if(isilUserDetailsService.getTipoUsuario()==1) {
            return "/home/login/index";
        }
        else{
            return "redirect:/admin/usuarios";
        }


    }    @GetMapping("/registro/usuario")
    public String usuariosRegister(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "/home/registro/index";
    }

    @PostMapping("/registro/usuario/saving")
    public String usuariosRegisterSaving(Usuario usuario) {
        usuarioService.saveOrUpdate(usuario);
        return "/home/registro/validating";
    }

    @GetMapping("/admin/usuarios/estadoUsuario/{id}/{estado}")
    public String estadoUsuario(@PathVariable Long id,@PathVariable Integer estado) {
        usuarioService.estadoUsuario(id,estado);
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionUser");
        return "/index";
    }

}
