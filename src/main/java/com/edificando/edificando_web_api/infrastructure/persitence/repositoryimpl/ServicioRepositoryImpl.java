package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.application.mapper.ServicioMapper;
import com.edificando.edificando_web_api.domain.model.Servicio;
import com.edificando.edificando_web_api.domain.repository.ServicioRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ServicioEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ServicioRepositoryImpl implements ServicioRepository {

    private final JpaServicioRepository jpaServicioRepository;
    private final ServicioMapper servicioMapper;

        @Override
    public Servicio save(Servicio servicio) {
        ServicioEntity entity = servicioMapper.toEntity(servicio);
        return servicioMapper.toDomain(jpaServicioRepository.save(entity));
    }

    @Override
    public Optional<Servicio> findById(Integer id) {
        return jpaServicioRepository.findById(id).map(servicioMapper::toDomain);
    }

    @Override
    public List<Servicio> findAll() {
        return jpaServicioRepository.findAll()
                .stream()
                .map(servicioMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {jpaServicioRepository.deleteById(id);}

    @Override
    public List<ServicioDto> findByTipoServicio(Integer tipoServicioId) {
        return jpaServicioRepository.findServiciosByTipoServicio(tipoServicioId);
    }

    @Override
    public Page<ServicioDto> findAllPaged(Pageable pageable) {
            return jpaServicioRepository.findAllServiciosDto(pageable);
    }

    @Override
    public Page<ServicioDto> findByTipoServicioPaged(Integer tipoServicioId, Pageable pageable) {
            return jpaServicioRepository.findServiciosByTipoServicioPaged(tipoServicioId, pageable);
    }
}

