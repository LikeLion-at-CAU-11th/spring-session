package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.LetterEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {

    default LetterEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException());
    }
}
