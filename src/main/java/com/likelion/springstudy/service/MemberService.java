package com.likelion.springstudy.service;


import com.likelion.springstudy.dto.response.member.MemberGetResponse;
import com.likelion.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

}
