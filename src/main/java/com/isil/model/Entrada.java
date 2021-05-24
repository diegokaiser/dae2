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
@Table(name = "Entrada")
public class Entrada {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEntrada")
    private Long idEntrada;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "idSala")
    private Integer idSala;

    @Column(name = "idPelicula")
    private Integer idPelicula;

    @Column(name = "stock")
    private Integer stock;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "admiModificacion")
    private LocalDate admiModificacion;
}
