package com.gmail.jpalvesl101.vuttr.repository;

import com.gmail.jpalvesl101.vuttr.entity.TagDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagDTO, Long> {
}
