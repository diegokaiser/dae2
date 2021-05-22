package com.isil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.isil.model.Usuario;
import com.isil.service.UsuarioService;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/admin/usuarios")
    public String usuarios(Model model) {
        usuarioService.findAll().ifPresent(usuarios -> model.addAttribute("usuarios", usuarios));
        return "admin/usuarios/index";
    }

    @GetMapping("/admin/usuarios/add")
    public String usuariosAdd(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/usuarios/add";
    }

    @PostMapping("/admin/usuarios/save")
    public String usuariosSave(Usuario usuario) {
        usuarioService.saveOrUpdate(usuario);
        return "redirect:/admin/usuarios/index";
    }

    @GetMapping("/admin/usuarios/edit/{id}")
    public String usuariosEdit(@PathVariable Long id, Model model) {
        usuarioService.findById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "admin/usuarios/add";
    }

    @GetMapping("/admin/usuarios/delete/{id}")
    public String usuariosDelete(@PathVariable Long id, Model model) {
        usuarioService.deleteById(id);
        return "redirect:/admin/usuarios/index";
    }
}