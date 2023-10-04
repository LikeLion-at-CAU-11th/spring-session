package com.likelion.springstudy.dto.response.box;

import com.likelion.springstudy.domain.entity.BoxEntity;

public record BoxGetResponse(
        String name
) {

    public static BoxGetResponse of(BoxEntity box) {
        return new BoxGetResponse(box.getName());
    }
}
