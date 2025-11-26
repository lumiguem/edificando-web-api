package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.infrastructure.persitence.entity.TipoServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTipoServicioRepository extends JpaRepository<TipoServicioEntity, Integer> {
}
