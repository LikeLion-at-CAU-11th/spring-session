package com.likelion.springstudy.service;


import com.likelion.springstudy.domain.entity.LetterEntity;
import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.dto.request.letter.LetterUpdateRequest;
import com.likelion.springstudy.dto.response.letter.LetterGetResponse;
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

    @Transactional
    public void updateLetter(Long letterId, LetterUpdateRequest request) {
        LetterEntity letter = letterJpaRepository.findByIdOrThrow(letterId);
        letter.updateTitle(request.title());
        letter.updateContent(request.content());
    }

    public LetterGetResponse getById(Long id) {
        return LetterGetResponse.of(letterJpaRepository.findByIdOrThrow(id));
    }

}
