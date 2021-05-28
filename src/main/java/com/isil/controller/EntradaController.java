package com.isil.controller;

import com.isil.model.Entrada;
import com.isil.service.EntradaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntradaController {
    private final EntradaService entradaService;

    public EntradaController(EntradaService entradaService) {
        this.entradaService = entradaService;
    }

    /* admin entradas */
    @GetMapping("/admin/entradas")
    public String entradas(Model model) {
        entradaService.findAll().ifPresent(entradas -> model.addAttribute("entradas", entradas));
        return "admin/entradas/index";
    }

    @GetMapping("/admin/entradas/add")
    public String entradasAdd(Model model) {
        model.addAttribute("entrada", new Entrada());
        return "admin/entradas/add";
    }

    @PostMapping("/admin/entradas/save")
    public String entradasSave(Entrada entrada) {
        entradaService.saveOrUpdate(entrada);
        return "redirect:/admin/entradas/index";
    }

    @GetMapping("/admin/entradas/edit/{id}")
    public String entradasEdit(@PathVariable Long id, Model model) {
        entradaService.findById(id).ifPresent(entrada -> model.addAttribute("entrada", entrada));
        return "admin/entradas/add";
    }

    @GetMapping("/admin/entradas/delete/{id}")
    public String entradasDelete(@PathVariable Long id, Model model) {
        entradaService.deleteById(id);
        return "redirect:/admin/entradas/index";
    }
}
