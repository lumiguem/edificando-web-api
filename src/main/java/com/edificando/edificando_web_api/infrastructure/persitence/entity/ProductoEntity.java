package com.edificando.edificando_web_api.infrastructure.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id") // 👈 importante
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id") // 👈 importante
    private MarcaEntity marca;
}