package com.likelion.springstudy.repository;

import com.likelion.springstudy.domain.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    default MemberEntity findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 회원을 찾을 수 없습니다."));
    }
    @Query("select m from MemberEntity m where m.isDeleted = false")
    List<MemberEntity> findAllNotDeleted();

    // delete if deletedAt is not null and deletedAt < now()

    @Modifying
    @Query("delete from MemberEntity m where m.isDeleted = true and m.deletedAt < now()")
    void deleteExpiredMember();
}
