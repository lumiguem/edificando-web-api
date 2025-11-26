package com.edificando.edificando_web_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto
{
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;

    private TipoServicio tipoServicio;

}
