package com.edificando.edificando_web_api.application.mapper;


import com.edificando.edificando_web_api.application.dto.CategoriaDto;
import com.edificando.edificando_web_api.domain.model.Categoria;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    // ===== Entity ↔ Domain =====
    Categoria toDomain(CategoriaEntity entity);

    CategoriaEntity toEntity(Categoria domain);

    // ===== Domain ↔ DTO =====
    CategoriaDto toDto(Categoria domain);

    Categoria toDomainFromDto(CategoriaDto dto);
}
