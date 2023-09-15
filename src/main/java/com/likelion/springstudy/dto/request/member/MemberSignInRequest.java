package com.likelion.springstudy.dto.request.member;



public record MemberSignInRequest(
        String username,
        String password,
        String nickname
) {
}
