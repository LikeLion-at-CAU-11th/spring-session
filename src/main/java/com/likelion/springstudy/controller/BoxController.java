package com.likelion.springstudy.controller;


import com.likelion.springstudy.dto.request.box.BoxCreateRequest;
import com.likelion.springstudy.dto.response.box.BoxGetResponse;
import com.likelion.springstudy.service.BoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/box")
@RequiredArgsConstructor
public class BoxController {

    private final BoxService boxService;
    @PostMapping
    public ResponseEntity<Void> createLetterBox(@RequestBody BoxCreateRequest request, Long memberId) {
        URI location = URI.create("/api/box/" + boxService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{boxCode}")
    public ResponseEntity<BoxGetResponse> getBox(@PathVariable String boxCode) {
        return ResponseEntity.ok(boxService.getByCode(boxCode));
    }
}
