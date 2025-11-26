package com.edificando.edificando_web_api.domain.repository;


import com.edificando.edificando_web_api.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    List<Categoria> findAll();
    Optional<Categoria> findById(Integer id);
    Categoria save(Categoria categoria);
    void deleteById(Integer id);
}
