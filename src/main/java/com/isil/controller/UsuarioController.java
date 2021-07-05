package com.isil.controller;

import com.isil.service.PeliculaService;
import com.isil.service.TipoUsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.isil.model.Usuario;
import com.isil.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final TipoUsuarioService tipoUsuarioService;
    private final PeliculaService peliculaService;

    public UsuarioController(UsuarioService usuarioService,
                             TipoUsuarioService tipoUsuarioService,
                             PeliculaService peliculaService) {
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
        this.peliculaService = peliculaService;
    }


    /* admin usuarios */
    @GetMapping("/admin/usuarios")
    public String usuarios(Model model) {
        usuarioService.findAll().ifPresent(usuarios -> model.addAttribute("usuarios", usuarios));
        return "admin/usuarios/index";
    }

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
    @GetMapping("/home/login")
    public String usuariosLogin(Model model) {
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        return "/home/login/index";
    }

    /* register */
    @GetMapping("/registro/usuario")
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

/*    @GetMapping("/admin/usuarios/estadoUsuario/{estado}/{id}")
    public String estadoUsuario(@PathVariable Long estado,Long id) {
        System.out.println("Si toy we 1");
        usuarioService.editarUsuario(estado,id);
        System.out.println("Si toy we 2");
        return "redirect:/admin/usuarios/index";

    }*/





/*    @PostMapping("/admin/usuarios/deshabilitarEstado")
    public void deshabilitarEstado(Integer estado,Integer id) {
        usuarioService.editarUsuario(estado,id);
    }*/

}
