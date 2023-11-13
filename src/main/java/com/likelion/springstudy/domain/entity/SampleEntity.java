package com.likelion.springstudy.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
public class SampleEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

}
