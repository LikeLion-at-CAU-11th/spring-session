package com.likelion.springstudy.scheduling;


import com.likelion.springstudy.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExpiredMemberDeleteBatch {

    private final MemberJpaRepository memberJpaRepository;

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpiredMember() {
        memberJpaRepository.deleteExpiredMember();
    }
}
