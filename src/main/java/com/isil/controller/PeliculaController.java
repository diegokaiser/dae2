package com.isil.controller;

import com.isil.model.Pelicula;
import com.isil.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    /* admin usuarios */
    @GetMapping("/admin/estrenos")
    public String peliculas(Model model) {
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        return "admin/estrenos/index";
    }

    @GetMapping("/admin/estrenos/add")
    public String peliculasAdd(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "admin/estrenos/add";
    }

    @PostMapping("/admin/estrenos/save")
    public String peliculasSave(Pelicula pelicula) {
        peliculaService.saveOrUpdate(pelicula);
        return "redirect:/admin/estrenos/index";
    }

    @GetMapping("/admin/estrenos/edit/{id}")
    public String peliculasEdit(@PathVariable Long id, Model model) {
        peliculaService.findById(id).ifPresent(pelicula -> model.addAttribute("pelicula", pelicula));
        return "admin/estrenos/add";
    }

    @GetMapping("/admin/estrenos/delete/{id}")
    public String peliculasDelete(@PathVariable Long id, Model model) {
        return "redirect:/admin/estrenos/index";
    }
}
