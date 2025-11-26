package com.edificando.edificando_web_api.application.mapper;


import com.edificando.edificando_web_api.application.dto.MarcaDto;
import com.edificando.edificando_web_api.domain.model.Marca;
import com.edificando.edificando_web_api.infrastructure.persitence.entity.MarcaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MarcaMapper {
    Marca toDomain(MarcaEntity entity);
    MarcaEntity toEntity(Marca model);

    MarcaDto toDto(Marca model);
    Marca toDomainFromDto(MarcaDto dto);
}
