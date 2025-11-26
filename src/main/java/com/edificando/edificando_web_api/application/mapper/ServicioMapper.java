package com.edificando.edificando_web_api.application.mapper;

import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.domain.model.Servicio;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ServicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicioMapper {

    // Entity -> Domain

    @Mapping(source = "tipoServicio", target = "tipoServicio")
    Servicio toDomain(ServicioEntity entity);

    // Domain -> Entity

    @Mapping(source = "tipoServicio", target = "tipoServicio")
    ServicioEntity toEntity(Servicio domain);

    // Domain -> DTO
    @Mapping(source = "tipoServicio.id", target = "tipoServicioId")
    @Mapping(source = "tipoServicio.nombre", target = "tipoServicioNombre")
    ServicioDto toDto(Servicio servicio);

    // DTO -> Domain
    @Mapping(target = "tipoServicio", expression = "java(new TipoServicio(dto.getTipoServicioId(), dto.getTipoServicioNombre()))")
    Servicio toDomain(ServicioDto dto);
}
