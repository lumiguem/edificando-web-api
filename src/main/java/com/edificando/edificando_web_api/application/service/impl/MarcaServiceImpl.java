package com.edificando.edificando_web_api.application.service.impl;


import com.edificando.edificando_web_api.application.service.MarcaService;
import com.edificando.edificando_web_api.domain.model.Marca;
import com.edificando.edificando_web_api.domain.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {
    private final MarcaRepository marcaRepository;

    @Override
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Optional<Marca> findById(Integer id) {
        return marcaRepository.findById(id);
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        marcaRepository.deleteById(id);
    }
}
