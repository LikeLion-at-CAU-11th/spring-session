package com.likelion.springstudy.dto.response.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.likelion.springstudy.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberGetResponse {

    private String name;
    private String nickname;

    public static MemberGetResponse of(MemberEntity member) {
        return new MemberGetResponse(member.getName(), member.getNickname());
    }
}
