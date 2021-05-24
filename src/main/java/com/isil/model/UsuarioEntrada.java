package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "UsuarioEntrada")
public class UsuarioEntrada {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUsuarioEntrada")
    private Integer idUsuarioEntrada;

    @Column(name = "idCompra")
    private Integer idCompra;

    @Column(name = "estado")
    private Integer estado;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;
}
