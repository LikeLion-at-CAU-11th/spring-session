package com.likelion.springstudy.domain.entity;


import com.likelion.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "letter_box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoxEntity extends BaseTimeEntity {

    private static final int DEFAULT_LETTER_LIMIT = 20;

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int letterLimit = DEFAULT_LETTER_LIMIT;

    private String code;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    // 양방향 연관관계 매핑
    @OneToMany(mappedBy = "box")
    private final List<LetterEntity> letters = new ArrayList<>();

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
