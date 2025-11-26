package com.edificando.edificando_web_api.domain.repository;

import com.edificando.edificando_web_api.domain.model.Categoria;
import com.edificando.edificando_web_api.domain.model.TipoServicio;

import java.util.List;
import java.util.Optional;

public interface TipoServicioRepository {
    List<TipoServicio> findAll();
    Optional<TipoServicio> findById(Integer id);
    TipoServicio save(TipoServicio tipoServicio);
    void deleteById(Integer id);
}
