package com.isil.controller;

import com.isil.model.UsuarioEntrada;
import com.isil.service.UsuarioEntradaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class UsuarioEntradaController {
    private final UsuarioEntradaService usuarioEntradaService;

    public UsuarioEntradaController(UsuarioEntradaService usuarioEntradaService) {
        this.usuarioEntradaService = usuarioEntradaService;
    }

    /* admin usuariosEntradas */
    @GetMapping("/admin/usuariosEntradas")
    public String usuariosEntradas(Model model) {
        usuarioEntradaService.findAll().ifPresent(usuariosEntradas -> model.addAttribute("usuariosEntradas", usuariosEntradas));
        return "admin/usuariosEntradas/index";
    }

    @GetMapping("/admin/usuariosEntradas/add")
    public String usuarioEntradaAdd(Model model) {
        model.addAttribute("usuariosEntradas", new UsuarioEntrada());
        return "admin/usuariosEntradas/add";
    }

    @PostMapping("/admin/usuariosEntradas/save")
    public String usuarioEntradaSave(UsuarioEntrada usuarioEntrada) {
        usuarioEntradaService.saveOrUpdate(usuarioEntrada);
        return "redirect:/admin/usuariosEntradas/index";
    }

    @GetMapping("/admin/usuariosEntradas/edit/{id}")
    public String usuarioEntradaEdit(@PathVariable Long id, Model model) {
        usuarioEntradaService.findById(id).ifPresent(usuarioEntrada -> model.addAttribute("usuarioEntrada", usuarioEntrada));
        return "admin/usuariosEntradas/add";
    }

    @PostMapping("/admin/usuariosEntradas/delete/{id}")
    public String usuarioEntradaDelete(@PathVariable Long id, Model model) {
        usuarioEntradaService.deleteById(id);
        return "redirect:/admin/usuariosEntradas/index";
    }
}
