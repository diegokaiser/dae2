package com.isil.controller;

import com.isil.model.CineSede;
import com.isil.service.CineSedeService;
import com.isil.service.CineService;
import com.isil.service.DistritoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CineSedeController {
    
    private final CineSedeService cineSedeService;
    private final DistritoService distritoService;
    private final CineService cineService;

    public CineSedeController(CineSedeService cineSedeService, DistritoService distritoService, CineService cineService) {
        this.cineSedeService = cineSedeService;
        this.distritoService = distritoService;
        this.cineService = cineService;
    }

    Integer idCineSedeRetorna;//para guardar el id de las sedes y poner retornar luego del update

    /* admin cinesSede */
    @GetMapping("/admin/cineSede/{id}")
    public String cinesSede(Model model,@PathVariable Integer id) {
        cineSedeService.findByIdCine(id).ifPresent(cinesSede -> model.addAttribute("cinesSede", cinesSede));
        idCineSedeRetorna=id;
        return "admin/cines/sedes/index";
    }

/*
    @GetMapping("/admin/cineSede/{id}")
    public String cinesSede(Model model,@PathVariable Integer id) {
        System.out.println("aber1");
        cineSedeService.findByIdCine(id);
        return "admin/cines/sedes";
    }
*/

    @GetMapping("/admin/cinesSede/add")
    public String cinesSedeAdd(Model model) {
        model.addAttribute("cineSede", new CineSede());
        distritoService.findAll().ifPresent(distritos -> model.addAttribute("distritos", distritos));
        cineService.findByIdCine(Long.valueOf(idCineSedeRetorna)).ifPresent(cines -> model.addAttribute("cines", cines));



        return "admin/cines/sedes/add";
    }

    @PostMapping("/admin/cinesSede/save")
    public String cinesSedeSave(CineSede cineSede) {
        cineSedeService.saveOrUpdate(cineSede);
        return "redirect:/admin/cineSede/"+idCineSedeRetorna;
    }

    @GetMapping("/admin/cinesSede/edit/{id}")
    public String cinesSedeEdit(@PathVariable Long id, Model model) {
        cineSedeService.findById(id).ifPresent(cineSede -> model.addAttribute("cineSede", cineSede));
        distritoService.findAll().ifPresent(distritos -> model.addAttribute("distritos", distritos));
        cineService.findByIdCine(Long.valueOf(idCineSedeRetorna)).ifPresent(cines -> model.addAttribute("cines", cines));


        return "admin/cines/sedes/add";
    }

    @PostMapping("/admin/cinesSede/delete/{id}")
    public String cinesSedeDelete(@PathVariable Long id, Model model) {
        cineSedeService.deleteById(id);
        return "redirect:/admin/cinesSede";
    }

    @GetMapping("/admin/cinesSede/estadoCineSede/{id}/{estado}")
    public String estadoSede(@PathVariable Long id,@PathVariable Integer estado) {
        cineSedeService.estadoCineSede(id,estado);
        return "redirect:/admin/cineSede/"+idCineSedeRetorna; //jalo el id de la variable global donde se guardo el id del Cine

    }

}
