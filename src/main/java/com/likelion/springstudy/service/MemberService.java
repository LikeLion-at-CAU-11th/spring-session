package com.likelion.springstudy.service;


import com.likelion.springstudy.domain.entity.MemberEntity;
import com.likelion.springstudy.dto.request.member.MemberSignInRequest;
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

    @Transactional
    public Long create(MemberSignInRequest request) {
        //TODO: create auth logic
        MemberEntity member = memberJpaRepository.save(
                MemberEntity.builder()
                        .nickname(request.nickname())
                        .name(request.username())
                        .build()
        );
        return member.getId();
    }

    public MemberGetResponse getById(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    @Transactional
    public void deleteById(Long id) {
        MemberEntity member = memberJpaRepository.findByIdOrThrow(id);
        member.softDelete();
    }

    @Transactional
    public void recoverMemberInfo(Long id) {
        MemberEntity member = memberJpaRepository.findByIdOrThrow(id);
        member.recover();
    }

    @Transactional
    public void deleteExpiredMember() {
    }

}
