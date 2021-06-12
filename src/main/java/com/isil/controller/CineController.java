package com.isil.controller;

import com.isil.model.Cine;
import com.isil.service.CineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CineController {
    private final CineService cineService;

    public CineController(CineService cineService) {
        this.cineService = cineService;
    }

    /* admin cines */
    @GetMapping("/admin/cines")
    public String cines(Model model) {
        cineService.findAll().ifPresent(cines -> model.addAttribute("cines", cines));
        return "admin/cines/index";
    }

    @GetMapping("/admin/cines/add")
    public String cinesAdd(Model model) {
        model.addAttribute("cine", new Cine());
        return "admin/cines/add";
    }

    @PostMapping("/admin/cines/save")
    public String cinesSave(Cine cine) {
        cineService.saveOrUpdate(cine);
        return "redirect:/admin/cines";
    }

    @GetMapping("/admin/cines/edit/{id}")
    public String cinesEdit(@PathVariable Long id, Model model) {
        cineService.findById(id).ifPresent(cine -> model.addAttribute("cine", cine));
        return "admin/cines/add";
    }

    @PostMapping("/admin/cines/delete/{id}")
    public String cinesDelete(@PathVariable Long id, Model model) {
        cineService.deleteById(id);
        return "redirect:/admin/cines/index";
    }
    @GetMapping("/admin/estrenos/estadoCine/{id}/{estado}")
    public String estadoCine(@PathVariable Long id,@PathVariable Integer estado) {
        cineService.estadoCine(id,estado);
        return "redirect:/admin/cines";

    }
}
