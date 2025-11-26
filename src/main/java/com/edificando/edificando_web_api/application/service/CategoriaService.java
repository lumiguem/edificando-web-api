package com.edificando.edificando_web_api.application.service;

import com.edificando.edificando_web_api.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    Categoria save(Categoria categoria);
    Optional<Categoria> findById(Integer id);
    List<Categoria> findAll();
    void deleteById(Integer id);
}
