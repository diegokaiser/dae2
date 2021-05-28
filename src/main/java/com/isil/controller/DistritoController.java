package com.isil.controller;

import com.isil.model.Distrito;
import com.isil.service.DistritoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class DistritoController {
    private final DistritoService distritoService;

    public DistritoController(DistritoService distritoService) {
        this.distritoService = distritoService;
    }

    /* admin distritos */
    @GetMapping("/admin/distritos")
    public String distritos(Model model) {
        distritoService.findAll().ifPresent(distritos -> model.addAttribute("distritos", distritos));
        return "admin/distritos/index";
    }

    @GetMapping("/admin/distritos/add")
    public String distritoAdd(Model model) {
        model.addAttribute("distritos", new Distrito());
        return "admin/distritos/add";
    }

    @PostMapping("/admin/distritos/save")
    public String distritoSave(Distrito distrito) {
        distritoService.saveOrUpdate(distrito);
        return "redirect:/admin/distritos/index";
    }

    @GetMapping("/admin/distritos/edit/{id}")
    public String distritoEdit(@PathVariable Long id, Model model) {
        distritoService.findById(id).ifPresent(distrito -> model.addAttribute("distrito", distrito));
        return "admin/distritos/add";
    }

    @PostMapping("/admin/distritos/delete/{id}")
    public String distritoDelete(@PathVariable Long id, Model model) {
        distritoService.deleteById(id);
        return "redirect:/admin/distritos/index";
    }
}
