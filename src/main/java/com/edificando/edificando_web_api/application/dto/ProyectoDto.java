package com.edificando.edificando_web_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDto {
    private Long id;
    private String titulo;
    private String descripcion;
    private String imagen;

    private Integer tipoServicioId;
    private String tipoServicioNombre;
}
