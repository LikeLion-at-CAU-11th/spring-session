package com.likelion.springstudy.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "letter")
public class LetterEntity {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "box_id")
    private BoxEntity box;
}
