package com.gmail.jpalvesl101.vuttr.repository;

import com.gmail.jpalvesl101.vuttr.entity.ToolDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToolRepository extends JpaRepository<ToolDTO, Long> {
}
