package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;

import com.edificando.edificando_web_api.application.mapper.ProyectoMapper;
import com.edificando.edificando_web_api.domain.model.Proyecto;
import com.edificando.edificando_web_api.domain.repository.ProyectoRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProyectoEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProyectoRepositoryImpl implements ProyectoRepository {

    private final JpaProyectoRepository jpaProyectoRepository;
    private final ProyectoMapper proyectoMapper;

    @Override
    public Proyecto save(Proyecto proyecto) {
        ProyectoEntity entity = proyectoMapper.toEntity(proyecto);
        return proyectoMapper.toDomain(jpaProyectoRepository.save(entity));
    }

    @Override
    public Optional<Proyecto> findById(Integer id) {
        return jpaProyectoRepository.findById(id).map(proyectoMapper::toDomain);
    }

    @Override
    public List<Proyecto> findAll() {
        return jpaProyectoRepository.findAll()
                .stream()
                .map(proyectoMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpaProyectoRepository.deleteById(id);
    }
}
