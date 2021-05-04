package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Compra {
    private Integer idCompra;
    private Integer numeroEntradas;
    private Double total;
    private String fechaCompra;
    private String idUsuario;
    private String idEntrada;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
