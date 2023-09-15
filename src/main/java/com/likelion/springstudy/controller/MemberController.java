package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.member.MemberSignInRequest;
import com.likelion.springstudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> signIn(@RequestBody final MemberSignInRequest request) {
        memberService.
        return ResponseEntity.created().build();
    }

}
