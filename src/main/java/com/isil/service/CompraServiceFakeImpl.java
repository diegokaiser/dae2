package com.isil.service;


import com.isil.model.Compra;
import com.isil.model.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("compraServiceFake")
public class CompraServiceFakeImpl implements CompraService{

    List<Compra> compras = new ArrayList<>(
            Arrays.asList(
                    new Compra(1, 2, 15.99, "", "1", "1", 1, "", "", ""),
                    new Compra(2, 1, 15.99, "", "2", "2", 1, "", "", "")
            )
    );

    @Override
    public void create(Compra compra) {
        compras.add(compra);
    }

    @Override
    public Compra read(String idCompra) {
        return compras.stream()
                .filter(s -> idCompra.equals(s.getIdCompra()))
                .findFirst()
                .orElseGet(null);
    }

    @Override
    public void update(Compra compra) {
        Compra currentCompra = read(compra.getIdCompra().toString());
        if (currentCompra != null){
            int index = compras.indexOf(currentCompra);
            compras.set(index, compra);
        }
    }

    @Override
    public void delete(String idCompra) {
        Compra currentCompra = read(idCompra);
        compras.remove(currentCompra);
    }

    @Override
    public List<Compra> all() {
        return compras;
    }
}
