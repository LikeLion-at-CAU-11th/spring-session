package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.letter.LetterCreateRequest;
import com.likelion.springstudy.dto.request.letter.LetterUpdateRequest;
import com.likelion.springstudy.dto.response.letter.LetterGetResponse;
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

    @GetMapping("/{letterId}")
    public ResponseEntity<LetterGetResponse> getLetter(@PathVariable Long letterId) {
        return ResponseEntity.ok(letterService.getById(letterId));
    }

    @PutMapping("/{letterId}")
    public ResponseEntity<Void> updateLetter(@PathVariable Long letterId, @RequestBody LetterUpdateRequest request) {
        letterService.updateLetter(letterId, request);
        return ResponseEntity.noContent().build();
    }

}
