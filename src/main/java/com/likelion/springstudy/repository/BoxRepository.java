package com.likelion.springstudy.repository;


import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoxRepository {

    @Query(value = "SELECT * FROM box WHERE id = ?1",
            nativeQuery = true
    )
    Optional<BoxEntity> findById(Long id);
}
