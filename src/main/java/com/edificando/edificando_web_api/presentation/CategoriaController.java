package com.edificando.edificando_web_api.presentation;

import com.edificando.edificando_web_api.application.dto.CategoriaDto;
import com.edificando.edificando_web_api.application.mapper.CategoriaMapper;
import com.edificando.edificando_web_api.application.service.CategoriaService;
import com.edificando.edificando_web_api.domain.model.Categoria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    // 🔹 Crear
    @PostMapping
    public ResponseEntity<CategoriaDto> create(@RequestBody CategoriaDto categoriaDto) {
        Categoria categoria = categoriaMapper.toDomainFromDto(categoriaDto);
        Categoria saved = categoriaService.save(categoria);
        return ResponseEntity.ok(categoriaMapper.toDto(saved));
    }

    // 🔹 Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> getById(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria
                .map(value -> ResponseEntity.ok(categoriaMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Listar todos
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAll() {
        List<CategoriaDto> categorias = categoriaService.findAll()
                .stream()
                .map(categoriaMapper::toDto)
                .toList();
        return ResponseEntity.ok(categorias);
    }

    // 🔹 Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id,
                                               @RequestBody CategoriaDto categoriaDto) {
        Optional<Categoria> existente = categoriaService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Categoria categoria = categoriaMapper.toDomainFromDto(categoriaDto);
        categoria.setId(id); // asegurar que usemos el ID existente
        Categoria updated = categoriaService.save(categoria);

        return ResponseEntity.ok(categoriaMapper.toDto(updated));
    }

    // 🔹 Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Categoria> existente = categoriaService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
