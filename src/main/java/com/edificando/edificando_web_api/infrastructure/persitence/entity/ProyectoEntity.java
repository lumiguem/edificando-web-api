package com.edificando.edificando_web_api.infrastructure.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyectos")
@Getter
@Setter
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_tipo_servicio", referencedColumnName = "id") // 👈 importante
    private TipoServicioEntity tipoServicio;
}
