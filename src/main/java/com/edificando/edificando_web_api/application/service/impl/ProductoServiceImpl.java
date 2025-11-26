package com.edificando.edificando_web_api.application.service.impl;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.application.service.ProductoService;
import com.edificando.edificando_web_api.domain.model.Producto;
import com.edificando.edificando_web_api.domain.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDto> getProductosByCategoria(Integer categoriaId) {
        return productoRepository.findByCategoria(categoriaId);
    }

    @Override
    public Page<ProductoDto> getAllProductosPaged(Pageable pageable) {
        return productoRepository.findAllPaged(pageable);
    }

    @Override
    public Page<ProductoDto> getProductosByCategoriaPaged(Integer categoriaId, Pageable pageable) {
        return productoRepository.findByCategoriaPaged(categoriaId, pageable);
    }

}
