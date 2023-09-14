package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.BoxEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoxJpaRepository extends JpaRepository<BoxEntity, Long> {

}
