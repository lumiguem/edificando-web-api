package com.edificando.edificando_web_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String imagen;

    private Integer tipoServicioId;
    private String tipoServicioNombre;
}
