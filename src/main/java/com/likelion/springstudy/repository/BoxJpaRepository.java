package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoxJpaRepository extends JpaRepository<BoxEntity, Long> {

    default BoxEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new IllegalArgumentException("해당 박스가 존재하지 않습니다."));
    }

    default BoxEntity findByCodeOrThrow(String code) {
        return findByCode(code).orElseThrow(() -> new IllegalArgumentException("해당 박스가 존재하지 않습니다."));
    }

    Optional<BoxEntity> findByCode(String code);

}
