package com.edificando.edificando_web_api.domain.repository;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.domain.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    Producto save(Producto producto);
    Optional<Producto> findById(Integer id);
    List<Producto> findAll();
    void deleteById(Integer id);

    // Consulta específica
    List<ProductoDto> findByCategoria(Integer categoriaId);
    Page<ProductoDto> findAllPaged(Pageable pageable); // 👈 nuevo método
    Page<ProductoDto> findByCategoriaPaged(Integer categoriaId, Pageable pageable);


}
