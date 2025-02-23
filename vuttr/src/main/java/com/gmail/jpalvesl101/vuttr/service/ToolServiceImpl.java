package com.gmail.jpalvesl101.vuttr.service;

import com.gmail.jpalvesl101.vuttr.entity.TagDTO;
import com.gmail.jpalvesl101.vuttr.entity.ToolDTO;
import com.gmail.jpalvesl101.vuttr.repository.ToolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolServiceImpl {
    private final ToolRepository repository;
    private final TagServiceImpl tagService;

    public ToolServiceImpl(ToolRepository toolRepository, TagServiceImpl tagService) {
        this.repository = toolRepository;
        this.tagService = tagService;
    }

    public List<ToolDTO> findAll() {
        return repository.findAll();
    }

    public Optional<ToolDTO> findById(Long id) {
        return repository.findById(id);
    }

    public ToolDTO create(ToolDTO toolDTO) {
        tagService.saveTags(toolDTO.getTags(), toolDTO.getId());
        repository.save(toolDTO);

        List<TagDTO> tags = toolDTO.getTags().stream().map(tag -> {
            tag.setToolId(toolDTO.getId());
            return tag;
        }).toList();
        toolDTO.setTags(tags);

        return repository.save(toolDTO);
    }

    public ToolDTO update(ToolDTO toolDTO) {
        return repository.save(toolDTO);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
