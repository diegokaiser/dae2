package com.isil.controller;

import com.isil.model.Entrada;
import com.isil.model.Usuario;
import com.isil.service.EntradaService;
import com.isil.service.PeliculaService;
import com.isil.service.SalaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Controller
public class EntradaController {
    private final EntradaService entradaService;
    private final PeliculaService peliculaService;
    private final SalaService salaService;

    public EntradaController(EntradaService entradaService, PeliculaService peliculaService, SalaService salaService) {
        this.entradaService = entradaService;
        this.peliculaService = peliculaService;
        this.salaService = salaService;
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
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
/*
        salaService.findByIdCineSede(id).ifPresent(salas -> model.addAttribute("salas", salas));
*/
        salaService.findAll().ifPresent(salas -> model.addAttribute("salas", salas));
        return "admin/entradas/add";
    }
    @GetMapping("/home/estrenos/entrada/{id}")
    public String getEntrada(@PathVariable Integer id, Model model) {
/*
*/
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        salaService.findAll().ifPresent(salas -> model.addAttribute("salas", salas));
        entradaService.findById(Long.valueOf(id)).ifPresent(entradaObj -> model.addAttribute("entradaObj", entradaObj));
        final String[] pagina = new String[1];
        entradaService.findByIdPelicula(id).ifPresent(
                entradas ->{
                    model.addAttribute("entrada",entradas);
                    if (entradas.size() > 0) {
                        pagina[0]="home/compra/index";
                    }else{
                        pagina[0]="home/compra/nodisponible";
                    }

                }

        );
            return pagina[0];
    }


    @PostMapping("/admin/entradas/save")
    public String entradasSave(Entrada entrada) {
        entradaService.saveOrUpdate(entrada);
        return "redirect:/admin/entradas";
    }

    @GetMapping("/admin/entradas/edit/{id}")
    public String entradasEdit(@PathVariable Long id, Model model) {
        entradaService.findById(id).ifPresent(entrada -> model.addAttribute("entrada", entrada));
        peliculaService.findAll().ifPresent(peliculas -> model.addAttribute("peliculas", peliculas));
        salaService.findAll().ifPresent(salas -> model.addAttribute("salas", salas));

/*
        salaService.findByIdCineSede(id).ifPresent(salas -> model.addAttribute("salas", salas));
*/
        return "admin/entradas/add";
    }

    @GetMapping("/admin/entradas/delete/{id}")
    public String entradasDelete(@PathVariable Long id, Model model) {
        entradaService.deleteById(id);
        return "redirect:/admin/entradas/index";
    }

    @GetMapping("/admin/entradas/estadoEntrada/{id}/{estado}")
    public String estadoEntrada(@PathVariable Long id,@PathVariable Integer estado) {
        entradaService.estadoEntrada(id,estado);
        return "redirect:/admin/entradas";

    }
}
