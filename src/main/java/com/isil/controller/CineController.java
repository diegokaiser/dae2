package com.isil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.isil.model.Cine;
import com.isil.service.CineService;


@Controller
public class CineController {

    private final CineService cineService;

    @Autowired
    public CineController( @Qualifier("cineServiceFake") CineService cineService) {
        this.cineService = cineService;
    }

    @GetMapping("/cines")
    public String getAllCine(Model model){
        model.addAttribute("cines", cineService.all());
        return "cine"; //nombre de la pagina que queremos resolver
    }

    @GetMapping("/cines/add")
    public String cineAdd(Model model){
        model.addAttribute("cine", new Cine());
        return "cine-add";
    }

    @GetMapping("/cines/edit/{idCine}")
    public String cineEdit(@PathVariable String idCine, Model model){
        model.addAttribute("cine", cineService.read(idCine));
        return "cine-edit";
    }

    @GetMapping("/cines/delete/{idCine}")
    public String cineDelete(@PathVariable String idCine){
        cineService.delete(idCine);
        return "redirect:/cines";
    }

    @PostMapping("/cines/save")
    public String cineSave(Cine cine){
        cineService.create(cine);
        return "redirect:/cines";
    }

    @PostMapping("/cines/update")
    public String cineUpdate(Cine cine){
        cineService.update(cine);
        return "redirect:/cines";
    }
}
