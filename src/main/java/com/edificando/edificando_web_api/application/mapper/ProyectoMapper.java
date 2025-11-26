package com.edificando.edificando_web_api.application.mapper;

import com.edificando.edificando_web_api.application.dto.ProyectoDto;
import com.edificando.edificando_web_api.domain.model.Proyecto;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.ProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {

    @Mapping(source="tipoServicio", target = "tipoServicio")
    Proyecto toDomain(ProyectoEntity entity);

    @Mapping(source = "tipoServicio", target = "tipoServicio")
    ProyectoEntity toEntity(Proyecto domain);

    // Domain -> DTO
    @Mapping(source = "tipoServicio.id", target = "tipoServicioId")
    @Mapping(source = "tipoServicio.nombre", target = "tipoServicioNombre")
    ProyectoDto toDto(Proyecto proyecto);

    // DTO -> Domain
    @Mapping(target = "tipoServicio", expression = "java(new TipoServicio(dto.getTipoServicioId(), dto.getTipoServicioNombre()))")
    Proyecto toDomain(ProyectoDto dto);
}
