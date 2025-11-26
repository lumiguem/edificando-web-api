package com.edificando.edificando_web_api.presentation;

import com.edificando.edificando_web_api.application.dto.ProductoDto;
import com.edificando.edificando_web_api.application.mapper.ProductoMapper;
import com.edificando.edificando_web_api.application.service.ProductoService;
import com.edificando.edificando_web_api.domain.model.Producto;
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
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    @GetMapping
    public ResponseEntity<Page<ProductoDto>> listarProductos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size)     {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productoService.getAllProductosPaged(pageable));
    }

    @PostMapping
    public ResponseEntity<ProductoDto> create(@RequestBody ProductoDto productoDto) {
        Producto producto = productoMapper.toDomain(productoDto);
        Producto saved = productoService.save(producto);
        return ResponseEntity.ok(productoMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto
                .map(value -> ResponseEntity.ok(productoMapper.toDto(value)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> update(@PathVariable Integer id,
                                              @RequestBody ProductoDto productoDto) {
        Optional<Producto> existente = productoService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto producto = productoMapper.toDomain(productoDto);
        producto.setId(id);
        Producto updated = productoService.save(producto);

        return ResponseEntity.ok(productoMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Producto> existente = productoService.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProductoDto>> getProductosByCategoria(@PathVariable Integer categoriaId) {
        List<ProductoDto> productos = productoService.getProductosByCategoria(categoriaId);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categoria/{categoriaId}/paged")
    public ResponseEntity<Page<ProductoDto>> getProductosByCategoriaPaged(
            @PathVariable Integer categoriaId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(productoService.getProductosByCategoriaPaged(categoriaId, pageable));
    }

}
