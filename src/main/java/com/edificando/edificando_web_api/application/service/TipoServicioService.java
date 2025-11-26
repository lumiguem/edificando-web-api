package com.edificando.edificando_web_api.application.service;

import com.edificando.edificando_web_api.domain.model.TipoServicio;

import java.util.List;
import java.util.Optional;

public interface TipoServicioService {
    TipoServicio save(TipoServicio tipoServicio);
    Optional<TipoServicio> findById(Integer id);
    List<TipoServicio> findAll();
    void deleteById(Integer id);
}
