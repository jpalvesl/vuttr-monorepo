package com.gmail.jpalvesl101.vuttr.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ToolDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String link;

    @OneToMany
    @JoinColumn(name = "toolId")
    private List<TagDTO> tags = new ArrayList<>();
}
