package com.edificando.edificando_web_api.application.service;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.domain.model.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    Servicio save(Servicio servicio);
    Optional<Servicio> findById(Integer id);
    List<Servicio> findAll();
    void deleteById(Integer id);

    List<ServicioDto> getServiciosByTipoServicio(Integer tipoServicioId);
    Page<ServicioDto> getAllServiciosPaged(Pageable pageable);    Page<ServicioDto> getServiciosByTipoServicioPaged(Integer tipoServicioId, Pageable pageable);
}
