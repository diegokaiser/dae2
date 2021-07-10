package com.isil.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Pelicula")
public class Pelicula {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPelicula")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "duracion")
    private String duracion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaEstreno")
    private String fechaEstreno;

    @Column(name = "idioma")
    private String idioma;

    @Column(name = "pais")
    private String pais;

    @Column(name = "subtitulos")
    private Integer subtitulos;

    @Column(name = "doblada")
    private Integer doblada;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "genero")
    private String genero;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "recomendada")
    private Integer recomendada;

    @Column(name = "portada")
    private String portada;

    @Column(name = "destacada")
    private Integer destacada;

    @Column(name = "protagonistas")
    private String protagonistas;

    @Column(name = "portadaDestacada")
    private String portadaDestacada;


/*
    @DateTimeFormat(pattern = "dd-MM-yyyy")
*/
    @Column(name = "fechaRegistro")
    private LocalDate fechaRegistro;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;

    @Column(name = "admiModificacion")
    private String admiModificacion;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Entrada> entradas;


 /*   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEntrada", insertable = false, updatable = false)
    private Entrada entrada;*/
}
