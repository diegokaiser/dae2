package com.isil.controller;

import com.isil.model.Sala;
import com.isil.service.SalaService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class SalaController {
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    /* admin salas */
    @GetMapping("/admin/salas")
    public String salas(Model model) {
        salaService.findAll().ifPresent(salas -> model.addAttribute("salas", salas));
        return "admin/salas/index";
    }

    @GetMapping("/admin/salas/add")
    public String salaAdd(Model model) {
        model.addAttribute("salas", new Sala());
        return "admin/salas/add";
    }

    @PostMapping("/admin/salas/save")
    public String salaSave(Sala sala) {
        salaService.saveOrUpdate(sala);
        return "redirect:/admin/salas/index";
    }

    @GetMapping("/admin/salas/edit/{id}")
    public String salaEdit(@PathVariable Long id, Model model) {
        salaService.findById(id).ifPresent(sala -> model.addAttribute("sala", sala));
        return "admin/salas/add";
    }

    @PostMapping("/admin/salas/delete/{id}")
    public String salaDelete(@PathVariable Long id, Model model) {
        salaService.deleteById(id);
        return "redirect:/admin/salas/index";
    }
}
