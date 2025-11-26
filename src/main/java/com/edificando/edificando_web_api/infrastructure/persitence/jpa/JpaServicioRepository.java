package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ServicioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaServicioRepository extends JpaRepository<ServicioEntity, Integer> {

    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ServicioDto(" +
            "s.id, s.nombre, s.descripcion, s.precio, s.imagen, " +
            "s.tipoServicio.id, s.tipoServicio.nombre) " +
            "FROM ServicioEntity s " +
            "WHERE s.tipoServicio.id = :tipoServicioId")
    List<ServicioDto> findServiciosByTipoServicio(@Param("tipoServicioId") Integer tipoServicioId);

    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ServicioDto(" +
            "s.id, s.nombre, s.descripcion, s.precio, s.imagen, " +
            "s.tipoServicio.id, s.tipoServicio.nombre) " +
            "FROM ServicioEntity s")
    Page<ServicioDto> findAllServiciosDto(Pageable pageable);

    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ServicioDto(" +
            "s.id, s.nombre, s.descripcion, s.precio, s.imagen, " +
            "s.tipoServicio.id, s.tipoServicio.nombre) " +
            "FROM ServicioEntity s " +
            "WHERE s.tipoServicio.id = :tipoServicioId")
    Page<ServicioDto> findServiciosByTipoServicioPaged(
            @Param("tipoServicioId") Integer tipoServicioId,
            Pageable pageable);

}
