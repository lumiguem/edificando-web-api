package com.edificando.edificando_web_api.infrastructure.persitence.repositoryimpl;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.application.mapper.ProductoMapper;
import com.edificando.edificando_web_api.domain.model.Producto;
import com.edificando.edificando_web_api.domain.repository.ProductoRepository;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProductoEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.jpa.JpaProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    private final JpaProductoRepository jpaProductoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public Producto save(Producto producto) {
        ProductoEntity entity = productoMapper.toEntity(producto);
        return productoMapper.toDomain(jpaProductoRepository.save(entity));
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return jpaProductoRepository.findById(id).map(productoMapper::toDomain);
    }

    @Override
    public List<Producto> findAll() {
        return jpaProductoRepository.findAll()
                .stream()
                .map(productoMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        jpaProductoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDto> findByCategoria(Integer categoriaId) {
        // Aquí ya devuelve DTO directo desde el JpaRepository
        return jpaProductoRepository.findProductosByCategoria(categoriaId);
    }

    @Override
    public Page<ProductoDto> findAllPaged(Pageable pageable) {
        return jpaProductoRepository.findAllProductosDto(pageable);
    }

    @Override
    public Page<ProductoDto> findByCategoriaPaged(Integer categoriaId, Pageable pageable) {
        return jpaProductoRepository.findProductosByCategoriaPaged(categoriaId, pageable);
    }

}
