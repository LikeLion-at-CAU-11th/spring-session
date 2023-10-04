package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.LetterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<LetterEntity, Long> {
}
