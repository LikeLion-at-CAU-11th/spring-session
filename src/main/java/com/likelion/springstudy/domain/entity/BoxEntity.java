package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table(name = "letter_box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20;

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private int letterLimit = DEFAULT_LETTER_LIMIT;

    private String code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Builder
    public BoxEntity(String name, int letterLimit) {
        this.name = name;
        this.letterLimit = letterLimit;
    }

    @Builder
    public BoxEntity(String name, int letterLimit, String code, MemberEntity member) {
        validate(letterLimit);
        this.name = name;
        this.letterLimit = letterLimit;
        this.code = code;
        this.member = member;
    }

    private void validate(int letterLimit) {
        validateLetterLimit(letterLimit);
    }


    private void validateLetterLimit(int letterLimit) {
        if (letterLimit > DEFAULT_LETTER_LIMIT || letterLimit < 0) {
           throw new IllegalArgumentException("Invalid Letter Limit");
        }
    }
}
