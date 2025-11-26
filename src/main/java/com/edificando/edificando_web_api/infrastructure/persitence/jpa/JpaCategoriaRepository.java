package com.edificando.edificando_web_api.infrastructure.persitence.jpa;

import com.edificando.edificando_web_api.infrastructure.persitence.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
}
