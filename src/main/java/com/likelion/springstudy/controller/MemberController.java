package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.member.MemberSignInRequest;
import com.likelion.springstudy.dto.response.member.MemberGetResponse;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 특정 사용자 정보를 조회하는 API
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMember(@PathVariable("memberId") Long memberId) {
        return ResponseEntity.ok(memberService.getById(memberId));
    }

    @PostMapping
    public ResponseEntity<Void> signIn(@RequestBody MemberSignInRequest request) {
        URI location = URI.create("/api/member/" + memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> withdrawMembership(@PathVariable("memberId") Long memberId) {
        memberService.deleteById(memberId);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> recoverMembership(@PathVariable("memberId") Long memberId) {
        memberService.recoverMemberInfo(memberId);
        return ResponseEntity.ok().build();
    }
}
