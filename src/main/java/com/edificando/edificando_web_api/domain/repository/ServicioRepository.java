package com.edificando.edificando_web_api.domain.repository;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.domain.model.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServicioRepository {
    Servicio save(Servicio servicio);
    Optional<Servicio> findById(Integer id);
    List<Servicio>findAll();
    void deleteById(Integer id);

    List<ServicioDto>findByTipoServicio(Integer tipoServicioId);
    Page<ServicioDto> findAllPaged(Pageable pageable);
    Page<ServicioDto> findByTipoServicioPaged(Integer tipoServicioId, Pageable pageable);
}
