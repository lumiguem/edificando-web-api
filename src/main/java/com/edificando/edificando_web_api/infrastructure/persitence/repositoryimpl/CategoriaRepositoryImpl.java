package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;


import com.edificando.edificando_web_api.application.mapper.CategoriaMapper;
import com.edificando.edificando_web_api.domain.model.Categoria;
import com.edificando.edificando_web_api.domain.repository.CategoriaRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.CategoriaEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final JpaCategoriaRepository jpaRepository;
    private final CategoriaMapper mapper;

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity entity = mapper.toEntity(categoria);
        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Categoria> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        jpaRepository.deleteById(id);
    }
}
