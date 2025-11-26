package com.edificando.edificando_web_api.presentation;
import com.edificando.edificando_web_api.application.dto.ProyectoDto;
import com.edificando.edificando_web_api.application.mapper.ProyectoMapper;
import com.edificando.edificando_web_api.application.service.ProyectoService;
import com.edificando.edificando_web_api.domain.repository.ProyectoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/proyectos")
@RequiredArgsConstructor
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;
    private final ProyectoMapper proyectoMapper;
    private final ProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<List<ProyectoDto>> getAll() {
        List<ProyectoDto>proyectos = proyectoService.findAll()
                .stream()
                .map(proyectoMapper::toDto)
                .toList();
        return ResponseEntity.ok(proyectos);
    }
}
