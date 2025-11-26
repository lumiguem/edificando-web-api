package com.edificando.edificando_web_api.domain.repository;

import com.edificando.edificando_web_api.domain.model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepository {
    Proyecto save(Proyecto proyecto);
    Optional<Proyecto> findById(Integer id);
    List<Proyecto> findAll();
    void deleteById(Integer id);
}
