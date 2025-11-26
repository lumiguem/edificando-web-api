package com.edificando.edificando_web_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen;

    private Categoria categoria;
    private Marca marca;
}