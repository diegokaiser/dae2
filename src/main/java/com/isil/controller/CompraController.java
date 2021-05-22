package com.isil.controller;

import com.isil.model.Compra;
import com.isil.service.CompraServiceFakeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CompraController {

    private final CompraServiceFakeImpl compraService;

    @Autowired
    public CompraController( @Qualifier("compraServiceFake") CompraServiceFakeImpl compraService) {
        this.compraService = compraService;
    }

    @GetMapping("/compras")
    public String getAllCompras(Model model){
        model.addAttribute("compras", compraService.all());
        return "compra"; //nombre de la pagina que queremos resolver
    }

    @GetMapping("/compras/add")
    public String compraAdd(Model model){
        model.addAttribute("compra", new Compra());
        return "compra-add";
    }

    @GetMapping("/compras/edit/{idCompra}")
    public String compraEdit(@PathVariable String idCompra, Model model){
        model.addAttribute("compra", compraService.read(idCompra));
        return "compra-edit";
    }

    @GetMapping("/compras/delete/{idCompra}")
    public String compraDelete(@PathVariable String idCompra){
        compraService.delete(idCompra);
        return "redirect:/compras";
    }

    @PostMapping("/compras/save")
    public String compraSave(Compra compra){
        compraService.create(compra);
        return "redirect:/compras";
    }

    @PostMapping("/compras/update")
    public String compraUpdate(Compra compra){
        compraService.update(compra);
        return "redirect:/compras";
    }
}
