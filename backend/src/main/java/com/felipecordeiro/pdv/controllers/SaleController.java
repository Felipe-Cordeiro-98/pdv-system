package com.felipecordeiro.pdv.controllers;

import com.felipecordeiro.pdv.dto.SaleDTO;
import com.felipecordeiro.pdv.dto.SaleResponseDTO;
import com.felipecordeiro.pdv.services.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService service;

    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(@RequestBody SaleDTO dto) {
        SaleResponseDTO entity = service.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(entity.id()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

}
