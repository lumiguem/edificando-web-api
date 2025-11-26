package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.infrastructure.persitence.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMarcaRepository extends JpaRepository<MarcaEntity, Integer> {
}
