package com.edificando.edificando_web_api.application.service.impl;

import com.edificando.edificando_web_api.application.service.ProyectoService;
import com.edificando.edificando_web_api.domain.model.Proyecto;
import com.edificando.edificando_web_api.domain.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;


    @Override
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Optional<Proyecto> findById(Integer id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        proyectoRepository.deleteById(id);
    }
}
