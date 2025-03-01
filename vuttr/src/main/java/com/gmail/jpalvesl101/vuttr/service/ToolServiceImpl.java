package com.gmail.jpalvesl101.vuttr.service;

import com.gmail.jpalvesl101.vuttr.entity.ToolDTO;
import com.gmail.jpalvesl101.vuttr.repository.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl {
    private final ToolRepository repository;

    public ToolServiceImpl(ToolRepository toolRepository) {
        this.repository = toolRepository;
    }

    public List<ToolDTO> findAll() {
        return repository.findAll();
    }

    public Optional<ToolDTO> findById(Long id) {
        return repository.findById(id);
    }

    public ToolDTO create(ToolDTO toolDTO) {
        return repository.save(toolDTO);
    }

    public ToolDTO update(ToolDTO toolDTO) {
        this.repository.findById(toolDTO.getId()).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar registro para podermos editar"));

        return repository.save(toolDTO);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
