package com.likelion.springstudy.dto.response.letter;

import com.likelion.springstudy.domain.entity.LetterEntity;

public record LetterGetResponse(
        String title,
        String content
) {

    public static LetterGetResponse of(LetterEntity letter) {
        return new LetterGetResponse(letter.getTitle(), letter.getContent());
    }
}
