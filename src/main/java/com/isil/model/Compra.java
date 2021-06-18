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
@Table(name = "Compra")
public class Compra {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCompra")
    private Long idCompra;

    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "idEntrada")
    private Integer idEntrada;

    @Column(name = "numeroEntradas")
    private Integer numeroEntradas;

    @Column(name = "total")
    private Double total;

    @Column(name = "estado")
    private Integer estado;

/*
    @DateTimeFormat(pattern = "dd-MM-yyyy")
*/
    @Column(name = "fechaCompra")
    private LocalDate fechaCompra;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "admiModificacion")
    private LocalDate admiModificacion;
}
