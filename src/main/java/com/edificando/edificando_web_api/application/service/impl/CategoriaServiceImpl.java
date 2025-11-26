package com.edificando.edificando_web_api.application.service.impl;

import com.edificando.edificando_web_api.application.service.CategoriaService;
import com.edificando.edificando_web_api.domain.model.Categoria;
import com.edificando.edificando_web_api.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}