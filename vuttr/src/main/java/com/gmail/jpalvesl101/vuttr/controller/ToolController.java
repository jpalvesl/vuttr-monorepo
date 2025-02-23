package com.gmail.jpalvesl101.vuttr.controller;

import com.gmail.jpalvesl101.vuttr.entity.ToolDTO;
import com.gmail.jpalvesl101.vuttr.service.ToolServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/tool")
public class ToolController {
    private final ToolServiceImpl service;

    public ToolController(ToolServiceImpl toolService) {
        this.service = toolService;
    }

    @GetMapping
    ResponseEntity findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    ResponseEntity create(@RequestBody ToolDTO toolDTO) {
        return ResponseEntity.ok().body(service.create(toolDTO));
    }

    @PutMapping("/{id}")
    ResponseEntity update(@RequestBody ToolDTO toolDTO, @PathVariable("id") Long id) {
        toolDTO.setId(id);
        return ResponseEntity.ok().body(service.update(toolDTO));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
