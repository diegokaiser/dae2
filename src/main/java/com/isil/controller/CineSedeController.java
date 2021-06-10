package com.isil.controller;

import com.isil.model.CineSede;
import com.isil.service.CineSedeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CineSedeController {
    
    private final CineSedeService cineSedeService;

    public CineSedeController(CineSedeService cineSedeService) {
        this.cineSedeService = cineSedeService;
    }


    /* admin cinesSede */
    @GetMapping("/admin/cinesSede/home")
    public String cinesSede(Model model) {
        cineSedeService.findAll().ifPresent(cinesSede -> model.addAttribute("cinesSede", cinesSede));
        return "admin/cines/sedes";
    }

    /* admin cinesSede por id del cine*/
/*    @GetMapping("/admin/cinesSede/{idCine}")
    public String cinesSede(Model model,@PathVariable Integer idCine) {
        System.out.println("Si toy we 1");
        cineSedeService.findAllByidCine(idCine).ifPresent(cinesSede -> model.addAttribute("cinesSede", cinesSede));
        System.out.println("Si toy we 2");

        return "admin/cines/sedes";
    }*/
/*    @GetMapping("/ayuda")
    public String ayuda(Model model){
        model.addAttribute("cineSede",new CineSede());
        return  "admin/cines/sedes";
    }

    @GetMapping("/admin/cinesSede")
    public String cinesSede(@RequestParam Integer idCine, Model model, @ModelAttribute("cineSede") CineSede cineSede) {
        System.out.println("Si toy we 1");
        model.addAttribute("findAllByidCine", cineSedeService.findAllByidCine(idCine));
        System.out.println("Si toy we 2");
        return "admin/cines/sedes";
    }*/

    @GetMapping("/admin/cinesSede/add")
    public String cinesSedeAdd(Model model) {
        model.addAttribute("cinesSede", new CineSede());
        return "admin/cines/sedeAdd";
    }

    @PostMapping("/admin/cinesSede/save")
    public String cinesSedeSave(CineSede cineSede) {
        cineSedeService.saveOrUpdate(cineSede);
        return "redirect:/admin/cinesSede";
    }

    @GetMapping("/admin/cinesSede/edit/{id}")
    public String cinesSedeEdit(@PathVariable Long id, Model model) {
        cineSedeService.findById(id).ifPresent(cineSede -> model.addAttribute("cineSede", cineSede));
        return "admin/cine/sedeAdd";
    }

    @PostMapping("/admin/cinesSede/delete/{id}")
    public String cinesSedeDelete(@PathVariable Long id, Model model) {
        cineSedeService.deleteById(id);
        return "redirect:/admin/cinesSede";
    }

    @GetMapping("/admin/cinesSede/estadoCineSede/{id}/{estado}")
    public String estadoEstreno(@PathVariable Long id,@PathVariable Integer estado) {
        cineSedeService.estadoCineSede(id,estado);
        return "redirect://admin/cinesSede/"+id;

    }

}
