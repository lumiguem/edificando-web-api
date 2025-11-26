package com.edificando.edificando_web_api.presentation;

import com.edificando.edificando_web_api.application.dto.MarcaDto;
import com.edificando.edificando_web_api.application.mapper.MarcaMapper;
import com.edificando.edificando_web_api.application.service.MarcaService;
import com.edificando.edificando_web_api.domain.model.Marca;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/marcas")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaService marcaService;
    private final MarcaMapper marcaMapper;

    @PostMapping
    public ResponseEntity<MarcaDto> create(@RequestBody MarcaDto marcaDto) {
        Marca marca = marcaMapper.toDomainFromDto(marcaDto);
        Marca saved = marcaService.save(marca);
        return ResponseEntity.ok(marcaMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDto> getById(@PathVariable Integer id) {
        Optional<Marca> marca = marcaService.findById(id);
        return marca
                .map(value -> ResponseEntity.ok(marcaMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MarcaDto>> getAll() {
        List<MarcaDto> marcas = marcaService.findAll()
                .stream()
                .map(marcaMapper::toDto)
                .toList();
        return ResponseEntity.ok(marcas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDto> update(@PathVariable Integer id,
                                           @RequestBody MarcaDto marcaDto) {
        Optional<Marca> existente = marcaService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Marca marca = marcaMapper.toDomainFromDto(marcaDto);
        marca.setId(id);
        Marca updated = marcaService.save(marca);

        return ResponseEntity.ok(marcaMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Marca> existente = marcaService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        marcaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
