package com.gmail.jpalvesl101.vuttr.controller;

import com.gmail.jpalvesl101.vuttr.entity.ToolDTO;
import com.gmail.jpalvesl101.vuttr.service.ToolServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/tool")
public class ToolController {
    private final ToolServiceImpl service;

    public ToolController(ToolServiceImpl toolService) {
        this.service = toolService;
    }

    @GetMapping
    ResponseEntity<List<ToolDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<ToolDTO>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    ResponseEntity<ToolDTO> create(@RequestBody ToolDTO toolDTO) {
        return ResponseEntity.ok().body(service.create(toolDTO));
    }

    @PutMapping("/{id}")
    ResponseEntity<ToolDTO> update(@RequestBody ToolDTO toolDTO, @PathVariable("id") Long id) {
        toolDTO.setId(id);
        return ResponseEntity.ok().body(service.update(toolDTO));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
