package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "letter_box")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoxEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private int letterLimit;

    private String code;

    @Builder
    public BoxEntity(String name, int letterLimit) {
        this.name = name;
        this.letterLimit = letterLimit;
    }
}
