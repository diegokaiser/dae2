package com.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String admiModificacion;

 /*   @OneToMany(mappedBy="entrada", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pelicula> peliculas ;*/


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPelicula", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSala", insertable = false, updatable = false)
    private Sala sala;

/*    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Entrada entrada;*/
}
