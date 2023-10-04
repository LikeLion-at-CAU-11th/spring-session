package com.likelion.springstudy.service;


import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.repository.LetterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LetterService {

    private final LetterJpaRepository letterJpaRepository;

    @Transactional
    public String create(LetterCreateRequest request) {
        LetterEntity letter = letterJpaRepository.save(LetterEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build());
        return letter.getId().toString();
    }

}
