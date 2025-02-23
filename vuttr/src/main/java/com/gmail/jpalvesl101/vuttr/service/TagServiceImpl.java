package com.gmail.jpalvesl101.vuttr.service;

import com.gmail.jpalvesl101.vuttr.entity.TagDTO;
import com.gmail.jpalvesl101.vuttr.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl {
    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    public List<TagDTO> saveTags(List<TagDTO> tagDTOs, Long toolId) {
        for (TagDTO tag : tagDTOs) {
            tag.setToolId(toolId);
            this.repository.save(tag);
        }

        return tagDTOs;
    }
}
