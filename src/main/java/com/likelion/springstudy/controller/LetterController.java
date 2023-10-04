package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/letter")
@RequiredArgsConstructor
public class LetterController {

    private final LetterService letterService;

    @PostMapping
    public ResponseEntity<Void> sendLetter(@RequestBody LetterCreateRequest request) {
        URI location = URI.create("/api/letter/" + letterService.create(request));
        return ResponseEntity.created(location).build();
    }

}
