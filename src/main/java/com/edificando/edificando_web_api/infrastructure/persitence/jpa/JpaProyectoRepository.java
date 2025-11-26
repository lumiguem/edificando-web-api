package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.application.dto.ProyectoDto;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProyectoRepository extends JpaRepository<ProyectoEntity, Integer> {
    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ServicioDto(" +
            "s.id, s.nombre, s.descripcion, s.precio, s.imagen, " +
            "s.tipoServicio.id, s.tipoServicio.nombre) " +
            "FROM ServicioEntity s " +
            "WHERE s.tipoServicio.id = :tipoServicioId")
List<ProyectoDto> findProyectoByTipoServicioId(@Param("tipoServicioId") Integer tipoServicioId);
}
