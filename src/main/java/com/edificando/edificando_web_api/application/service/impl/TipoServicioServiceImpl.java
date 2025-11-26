package com.edificando.edificando_web_api.application.service.impl;

import com.edificando.edificando_web_api.application.service.TipoServicioService;
import com.edificando.edificando_web_api.domain.model.TipoServicio;
import com.edificando.edificando_web_api.domain.repository.TipoServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl implements TipoServicioService {
    private final TipoServicioRepository tipoServicioRepository;

    @Override
    public TipoServicio save(TipoServicio tipoServicio) {
        return tipoServicioRepository.save(tipoServicio);
    }

    @Override
    public Optional<TipoServicio> findById(Integer id) {
        return tipoServicioRepository.findById(id);
    }

    @Override
    public List<TipoServicio> findAll() {
        return tipoServicioRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tipoServicioRepository.deleteById(id);
    }
}
