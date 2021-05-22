package com.isil.service;


import com.isil.model.Compra;

import java.util.List;

public interface CompraService {

    void create(Compra compra);
    Compra read(String idCompra);
    void update(Compra compra);
    void delete(String idCompra);

    List<Compra> all();
}
