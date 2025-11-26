package com.edificando.edificando_web_api.application.mapper;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.application.dto.TipoServicioDto;
import com.edificando.edificando_web_api.domain.model.Producto;
import com.edificando.edificando_web_api.domain.model.TipoServicio;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProductoEntity;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.TipoServicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoServicioMapper {

    // Entity -> Domain


    TipoServicio toDomain(TipoServicioEntity entity);

    // Domain -> Entity


    TipoServicioEntity toEntity(TipoServicio domain);

    // Domain -> DTO

    TipoServicioDto toDto(TipoServicio domain);

    // DTO -> Domain
    TipoServicio toDomainFromDto(TipoServicioDto dto);
}
