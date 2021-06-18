package com.isil.controller;

import com.isil.model.Sala;
import com.isil.service.CineSedeService;
import com.isil.service.SalaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalaController {
    private final SalaService salaService;
    private final CineSedeService cineSedeService;

    public SalaController(SalaService salaService, CineSedeService cineSedeService) {
        this.salaService = salaService;
        this.cineSedeService = cineSedeService;
    }

    /* admin salas */
/*    @GetMapping("/admin/salas")
    public String salas(Model model) {
        salaService.findAll().ifPresent(salas -> model.addAttribute("salas", salas));
        return "admin/salas/index";
    }*/

    Integer idCineSedeRetorna;//para guardar el id de las cinesede y poner retornar luego del update

    @GetMapping("/admin/salas/{id}")
    public String salas(Model model,@PathVariable Integer id) {
        salaService.findByIdCineSede(id).ifPresent(salas -> model.addAttribute("salas", salas));
        idCineSedeRetorna=id;
        return "admin/cines/salas/index";
    }



    @GetMapping("/admin/salas/add")
    public String salaAdd(Model model) {
        model.addAttribute("sala", new Sala());
        cineSedeService.findByIdCineSede(idCineSedeRetorna).ifPresent(salas -> model.addAttribute("salas", salas));
        return "admin/cines/salas/add";
    }

    @PostMapping("/admin/salas/save")
    public String salaSave(Sala sala) {
        salaService.saveOrUpdate(sala);
        return "redirect:/admin/salas/"+idCineSedeRetorna;
    }

    @GetMapping("/admin/salas/edit/{id}")
    public String salaEdit(@PathVariable Long id, Model model) {
        salaService.findById(id).ifPresent(sala -> model.addAttribute("sala", sala));
        cineSedeService.findByIdCineSede(idCineSedeRetorna).ifPresent(salas -> model.addAttribute("salas", salas));
        return "admin/cines/salas/add";
    }

    @PostMapping("/admin/salas/delete/{id}")
    public String salaDelete(@PathVariable Long id, Model model) {
        salaService.deleteById(id);
        return "redirect:/admin/salas/index";
    }

    @GetMapping("/admin/salas/estadoSala/{id}/{estado}")
    public String estadoSala(@PathVariable Long id,@PathVariable Integer estado) {
        salaService.estadoSala(id,estado);
        return "redirect:/admin/salas/{id}";
    }
}
