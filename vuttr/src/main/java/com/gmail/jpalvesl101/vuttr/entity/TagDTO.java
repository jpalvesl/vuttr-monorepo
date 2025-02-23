package com.gmail.jpalvesl101.vuttr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TagDTO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long toolId;
    private String name;
}
