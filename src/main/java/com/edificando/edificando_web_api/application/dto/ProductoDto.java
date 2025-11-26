package com.edificando.edificando_web_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen;

    private Integer categoriaId;
    private String categoriaNombre;

    private Integer marcaId;
    private String marcaNombre;
}
