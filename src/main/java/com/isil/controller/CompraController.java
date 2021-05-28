package com.isil.controller;

import com.isil.model.Compra;
import com.isil.service.CompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/compra")
    public String compras(Model model) {
        compraService.findAll().ifPresent(compras -> model.addAttribute("compras", compras));
        return "compra/index";
    }

    @GetMapping("/admin/compras/add")
    public String compraAdd(Model model) {
        model.addAttribute("compras", new Compra());
        return "compras/add";
    }

    @PostMapping("/admin/compras/save")
    public String compraSave(Compra compra) {
        compraService.saveOrUpdate(compra);
        return "redirect:compras/index";
    }

    @GetMapping("/admin/compras/edit/{id}")
    public String compraEdit(@PathVariable Long id, Model model) {
        compraService.findById(id).ifPresent(compra -> model.addAttribute("compra", compra));
        return "compras/add";
    }

    @PostMapping("/admin/compras/delete/{id}")
    public String compraDelete(@PathVariable Long id, Model model) {
        compraService.deleteById(id);
        return "redirect:compras/index";
    }

}
