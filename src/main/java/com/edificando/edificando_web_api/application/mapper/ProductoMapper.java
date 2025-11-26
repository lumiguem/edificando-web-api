package com.edificando.edificando_web_api.application.mapper;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.domain.model.Producto;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    // Entity -> Domain
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "marca", target = "marca")
    Producto toDomain(ProductoEntity entity);

    // Domain -> Entity
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "marca", target = "marca")
    ProductoEntity toEntity(Producto domain);

    // Domain -> DTO
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nombre", target = "categoriaNombre")
    @Mapping(source = "marca.id", target = "marcaId")
    @Mapping(source = "marca.nombre", target = "marcaNombre")
    ProductoDto toDto(Producto producto);

    // DTO -> Domain
    @Mapping(target = "categoria", expression = "java(new Categoria(dto.getCategoriaId(), dto.getCategoriaNombre()))")
    @Mapping(target = "marca", expression = "java(new Marca(dto.getMarcaId(), dto.getMarcaNombre()))")
    Producto toDomain(ProductoDto dto);
}
