package com.likelion.springstudy.domain.entity;

import com.likelion.springstudy.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자
@Getter
@Table(name = "member")
// JPA에서 기본적으로 table 이름을 명시 안해주면, class에 snake를 적용해서 저장.
// member_entity
public class MemberEntity extends BaseTimeEntity {

    private static final Long MEMBER_INFO_RETENTION_PERIOD = 30L;

    // 관계형 데이터베이스 -> 식별자를 갖는다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    private boolean isDeleted;
    private LocalDateTime deletedAt;

    @Builder
    public MemberEntity(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    // 회원 닉네임을 업데이트하는 기능
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void softDelete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now().plusDays(MEMBER_INFO_RETENTION_PERIOD);
    }

    public void recover() {
        this.isDeleted = false;
        this.deletedAt = null;
    }
}
