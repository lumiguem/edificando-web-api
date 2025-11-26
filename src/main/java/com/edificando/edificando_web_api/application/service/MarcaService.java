package com.edificando.edificando_web_api.application.service;


import com.edificando.edificando_web_api.domain.model.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    Marca save(Marca marca);
    Optional<Marca> findById(Integer id);
    List<Marca> findAll();
    void deleteById(Integer id);
}
