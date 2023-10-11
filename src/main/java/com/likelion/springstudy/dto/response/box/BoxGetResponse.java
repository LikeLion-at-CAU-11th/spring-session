package com.likelion.springstudy.dto.response.box;

import com.likelion.springstudy.domain.entity.BoxEntity;
import com.likelion.springstudy.dto.response.letter.LetterGetResponse;

import java.util.List;

public record BoxGetResponse(
        String name,
        List<LetterGetResponse> letters
) {

    public static BoxGetResponse of(BoxEntity box, List<LetterGetResponse> letters) {
        return new BoxGetResponse(box.getName(), letters);
    }
}
