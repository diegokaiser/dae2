package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioEntrada {
    private Integer idUsuarioEntrada;
    private Integer idCompra;
    private Integer status;
    private String created_at;
    private String updated_at;
    private String deleted_at;
}
