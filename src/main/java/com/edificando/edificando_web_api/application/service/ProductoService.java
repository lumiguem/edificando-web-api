package com.edificando.edificando_web_api.application.service;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.domain.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    List<Producto> findAll();
    void deleteById(Integer id);

    List<ProductoDto> getProductosByCategoria(Integer categoriaId);
    Page<ProductoDto> getAllProductosPaged(Pageable pageable);
    Page<ProductoDto> getProductosByCategoriaPaged(Integer categoriaId, Pageable pageable);


}
