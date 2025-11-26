package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;

import com.edificando.edificando_web_api.application.mapper.MarcaMapper;
import com.edificando.edificando_web_api.domain.model.Marca;
import com.edificando.edificando_web_api.domain.repository.MarcaRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.MarcaEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaMarcaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MarcaRepositoryImpl implements MarcaRepository {

    private final JpaMarcaRepository jpaMarcaRepository;
    private final MarcaMapper marcaMapper;

    @Override
    public Marca save(Marca marca) {
        MarcaEntity entity = marcaMapper.toEntity(marca);
        return marcaMapper.toDomain(jpaMarcaRepository.save(entity));
    }

    @Override
    public Optional<Marca> findById(Integer id) {
        return jpaMarcaRepository.findById(id).map(marcaMapper::toDomain);
    }

    @Override
    public List<Marca> findAll() {
        return jpaMarcaRepository.findAll().stream()
                .map(marcaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpaMarcaRepository.deleteById(id);
    }
}
