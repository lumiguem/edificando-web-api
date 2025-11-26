package com.edificando.edificando_web_api.infrastructure.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios")
@Getter
@Setter
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_tipo_servicio", referencedColumnName = "id") // 👈 importante
    private TipoServicioEntity tipoServicio;
}
