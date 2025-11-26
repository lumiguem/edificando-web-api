package com.edificando.edificando_web_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
