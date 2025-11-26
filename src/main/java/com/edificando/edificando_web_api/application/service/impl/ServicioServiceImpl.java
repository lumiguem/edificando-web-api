package com.edificando.edificando_web_api.application.service.impl;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.application.service.ServicioService;
import com.edificando.edificando_web_api.domain.model.Servicio;
import com.edificando.edificando_web_api.domain.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Optional<Servicio> findById(Integer id) {
        return servicioRepository.findById(id);
    }

    @Override
    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        servicioRepository.deleteById(id);
    }

    @Override
    public List<ServicioDto> getServiciosByTipoServicio(Integer tipoServicioId) {
        return servicioRepository.findByTipoServicio(tipoServicioId);
    }

    @Override
    public Page<ServicioDto> getAllServiciosPaged(Pageable pageable) {
        return servicioRepository.findAllPaged(pageable);
    }


    @Override
    public Page<ServicioDto> getServiciosByTipoServicioPaged(Integer tipoServicioId, Pageable pageable) {
        return servicioRepository.findByTipoServicioPaged(tipoServicioId, pageable);
    }
}
