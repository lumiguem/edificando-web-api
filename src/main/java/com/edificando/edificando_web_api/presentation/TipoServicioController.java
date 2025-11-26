package com.edificando.edificando_web_api.presentation;

import com.edificando.edificando_web_api.application.dto.CategoriaDto;
import com.edificando.edificando_web_api.application.dto.TipoServicioDto;
import com.edificando.edificando_web_api.application.mapper.TipoServicioMapper;
import com.edificando.edificando_web_api.application.service.TipoServicioService;
import com.edificando.edificando_web_api.domain.model.Categoria;
import com.edificando.edificando_web_api.domain.model.TipoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tiposervicios")
@RequiredArgsConstructor
public class TipoServicioController {
    private final TipoServicioService tipoServicioService;
    private final TipoServicioMapper tipoServicioMapper;

    // 🔹 Crear
    @PostMapping
    public ResponseEntity<TipoServicioDto> create(@RequestBody TipoServicioDto tipoServicioDto) {
        TipoServicio tipoServicio = tipoServicioMapper.toDomainFromDto(tipoServicioDto);
        TipoServicio saved = tipoServicioService.save(tipoServicio);
        return ResponseEntity.ok(tipoServicioMapper.toDto(saved));
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoServicioDto> getById(@PathVariable Integer id) {
        Optional<TipoServicio> tipoServicio = tipoServicioService.findById(id);
        return tipoServicio
                .map(value -> ResponseEntity.ok(tipoServicioMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Listar todos
    @GetMapping
    public ResponseEntity<List<TipoServicioDto>> getAll() {
        List<TipoServicioDto> tipoServicios = tipoServicioService.findAll()
                .stream()
                .map(tipoServicioMapper::toDto)
                .toList();
        return ResponseEntity.ok(tipoServicios);
    }

    // 🔹 Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<TipoServicioDto> update(@PathVariable Integer id,
                                               @RequestBody TipoServicioDto tipoServicioDto) {
        Optional<TipoServicio> existente = tipoServicioService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        TipoServicio tipoServicio = tipoServicioMapper.toDomainFromDto(tipoServicioDto);
        tipoServicio.setId(id); // asegurar que usemos el ID existente
        TipoServicio updated = tipoServicioService.save(tipoServicio);

        return ResponseEntity.ok(tipoServicioMapper.toDto(updated));
    }

    // 🔹 Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<TipoServicio> existente = tipoServicioService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        tipoServicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
