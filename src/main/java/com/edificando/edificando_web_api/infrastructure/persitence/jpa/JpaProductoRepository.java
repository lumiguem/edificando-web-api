package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    // Devuelve DTO directo con JPQL (optimizado)
    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ProductoDto(" +
            "p.id, p.nombre, p.descripcion, p.precio, p.stock, p.imagen, " +
            "p.categoria.id, p.categoria.nombre, " +
            "p.marca.id, p.marca.nombre) " +
            "FROM ProductoEntity p " +
            "WHERE p.categoria.id = :categoriaId")
    List<ProductoDto> findProductosByCategoria(@Param("categoriaId") Integer categoriaId);

    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ProductoDto(" +
            "p.id, p.nombre, p.descripcion, p.precio, p.stock, p.imagen, " +
            "p.categoria.id, p.categoria.nombre, " +
            "p.marca.id, p.marca.nombre) " +
            "FROM ProductoEntity p")
    Page<ProductoDto> findAllProductosDto(Pageable pageable);

    @Query("SELECT new com.edificando.edificando_web_api.application.dto.ProductoDto(" +
            "p.id, p.nombre, p.descripcion, p.precio, p.stock, p.imagen, " +
            "p.categoria.id, p.categoria.nombre, " +
            "p.marca.id, p.marca.nombre) " +
            "FROM ProductoEntity p " +
            "WHERE p.categoria.id = :categoriaId")
    Page<ProductoDto> findProductosByCategoriaPaged(
            @Param("categoriaId") Integer categoriaId,
            Pageable pageable);

}
