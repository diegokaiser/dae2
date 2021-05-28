package com.isil.controller;

import com.isil.model.TipoUsuario;
import com.isil.service.TipoUsuarioService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class TipoUsuarioController {
    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    /* admin tipoUsuarios */
    @GetMapping("/admin/tipoUsuarios")
    public String tipoUsuarios(Model model) {
        tipoUsuarioService.findAll().ifPresent(tipoUsuarios -> model.addAttribute("tipoUsuarios", tipoUsuarios));
        return "admin/tipoUsuarios/index";
    }

    @GetMapping("/admin/tipoUsuarios/add")
    public String tipoUsuarioAdd(Model model) {
        model.addAttribute("tipoUsuarios", new TipoUsuario());
        return "admin/tipoUsuarios/add";
    }

    @PostMapping("/admin/tipoUsuarios/save")
    public String tipoUsuarioSave(TipoUsuario tipoUsuario) {
        tipoUsuarioService.saveOrUpdate(tipoUsuario);
        return "redirect:/admin/tipoUsuarios/index";
    }

    @GetMapping("/admin/tipoUsuarios/edit/{id}")
    public String tipoUsuarioEdit(@PathVariable Long id, Model model) {
        tipoUsuarioService.findById(id).ifPresent(tipoUsuario -> model.addAttribute("tipoUsuario", tipoUsuario));
        return "admin/tipoUsuarios/add";
    }

    @PostMapping("/admin/tipoUsuarios/delete/{id}")
    public String tipoUsuarioDelete(@PathVariable Long id, Model model) {
        tipoUsuarioService.deleteById(id);
        return "redirect:/admin/tipoUsuarios/index";
    }
}
