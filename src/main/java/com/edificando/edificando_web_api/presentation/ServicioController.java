package com.edificando.edificando_web_api.presentation;
import com.edificando.edificando_web_api.application.dto.ServicioDto;
import com.edificando.edificando_web_api.application.mapper.ServicioMapper;
import com.edificando.edificando_web_api.application.service.ServicioService;
import com.edificando.edificando_web_api.domain.model.Servicio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;
    private final ServicioMapper servicioMapper;

    // 🔹 Listar servicios paginados
    @GetMapping
    public ResponseEntity<Page<ServicioDto>> listarServicios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(servicioService.getAllServiciosPaged(pageable));
    }

    // 🔹 Crear servicio
    @PostMapping
    public ResponseEntity<ServicioDto> create(@RequestBody ServicioDto servicioDto) {
        Servicio servicio = servicioMapper.toDomain(servicioDto);
        Servicio saved = servicioService.save(servicio);
        return ResponseEntity.ok(servicioMapper.toDto(saved));
    }

    // 🔹 Buscar servicio por Id
    @GetMapping("/{id}")
    public ResponseEntity<ServicioDto> getById(@PathVariable Integer id) {
        Optional<Servicio> servicio = servicioService.findById(id);
        return servicio
                .map(value -> ResponseEntity.ok(servicioMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Listar todos los servicios
    @GetMapping("/all")
    public ResponseEntity<List<ServicioDto>> getAll() {
        List<ServicioDto> servicios = servicioService.findAll()
                .stream()
                .map(servicioMapper::toDto)
                .toList();
        return ResponseEntity.ok(servicios);
    }

    // 🔹 Actualizar Servicios
    @PutMapping("/{id}")
    public ResponseEntity<ServicioDto> update(@PathVariable Integer id,
                                              @RequestBody ServicioDto servicioDto) {
        Optional<Servicio> existente = servicioService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Servicio servicio = servicioMapper.toDomain(servicioDto);
        servicio.setId(id);
        Servicio updated = servicioService.save(servicio);

        return ResponseEntity.ok(servicioMapper.toDto(updated));
    }

    // 🔹 Eliminar Servicios
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Servicio> existente = servicioService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        servicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Listar servicios por categoria
    @GetMapping("/tipoServicio/{tipoServicioId}")
    public ResponseEntity<List<ServicioDto>> getServiciosByTipoServicio(@PathVariable Integer tipoServicioId) {
        List<ServicioDto> servicios = servicioService.getServiciosByTipoServicio(tipoServicioId);
        return ResponseEntity.ok(servicios);
    }

    // 🔹 Listar servicios por categoria paginados
    @GetMapping("/tipoServicio/{tipoServicioId}/paged")
    public ResponseEntity<Page<ServicioDto>> getServiciosByTipoServicioPaged(
            @PathVariable Integer tipoServicioId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(servicioService.getServiciosByTipoServicioPaged(tipoServicioId, pageable));
    }

}
