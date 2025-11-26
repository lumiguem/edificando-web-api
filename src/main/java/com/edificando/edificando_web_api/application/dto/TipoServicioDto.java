package com.edificando.edificando_web_api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicioDto {
    private Integer id;
    private String nombre;
    private String descripcion;
}
