package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;


import com.edificando.edificando_web_api.application.mapper.TipoServicioMapper;
import com.edificando.edificando_web_api.domain.model.TipoServicio;
import com.edificando.edificando_web_api.domain.repository.TipoServicioRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.TipoServicioEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaTipoServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TipoServicioRepositoryImpl implements TipoServicioRepository {

    private final JpaTipoServicioRepository jpaTipoServicioRepository;
    private final TipoServicioMapper mapper;

    @Override
    public TipoServicio save(TipoServicio tipoServicio) {
        TipoServicioEntity entity = mapper.toEntity(tipoServicio);
        return mapper.toDomain(jpaTipoServicioRepository.save(entity));
    }

    @Override
    public Optional<TipoServicio> findById(Integer id) {
        return jpaTipoServicioRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<TipoServicio> findAll() {
        return jpaTipoServicioRepository.findAll()
        .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {jpaTipoServicioRepository.deleteById(id);}

}
