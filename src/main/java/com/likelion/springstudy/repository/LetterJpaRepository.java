package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.LetterEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {

    default LetterEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    List<LetterEntity> findAllByBox(BoxEntity box);
}
