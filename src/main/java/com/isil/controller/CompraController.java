package com.isil.controller;

import com.isil.model.Compra;
import com.isil.model.Entrada;
import com.isil.service.CompraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraController {
    private final CompraService compraService;
    Integer idUsuario=0;
    Integer idEntrada=0;
    Integer numeroEntradas=0;
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
        compra.setIdUsuario(idUsuario);
        compra.setIdEntrada(idEntrada);
        compra.setNumeroEntradas(numeroEntradas);
        compraService.saveOrUpdate(compra);
        return "home/compra/exito";
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


    @PostMapping("/home/estrenos/entrada")
    public String setEntrada(Entrada entrada,Model model) {
        model.addAttribute("compras", entrada);
        //Este codigo no tiene sentido,use el objeto entrada para traer los datos,
        //Ordenaremos los datos y los podremos en un objeto compra para registrarlo en la bd
        //dividimos el resultado del getTtipo que nos trae un String con varios datos
        String string =entrada.getTipo();
        String[] parts=string.split("-");

        String usuario=parts[0];
        String codigo=parts[1];
        String cine=parts[2];
        String sede=parts[3];
        String sala=parts[4];
        //cambiamos de nombre a las variables para no confundirnos
        Integer cantidad=entrada.getStock();
        Double precio= entrada.getPrecio();
        Double total=cantidad*precio;

        //seteamos a las variables locales
        idUsuario= Integer.valueOf(usuario);
        idEntrada=Integer.valueOf(codigo);
        numeroEntradas=cantidad;

        //enviamos los datos al html para mostrarlo
        model.addAttribute("codigo", codigo);
        model.addAttribute("cine", cine);
        model.addAttribute("sede", sede);
        model.addAttribute("sala", sala);
        model.addAttribute("cantidad", cantidad);
        model.addAttribute("precio", precio);
        model.addAttribute("total", total);
        //objeto de la compra que va hacer el registro en la bd
        Compra compra= new Compra();
        model.addAttribute("compra", compra);

        return "home/compra/compra";
    }

}
