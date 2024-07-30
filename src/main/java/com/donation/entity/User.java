package com.donation.entity;

import com.donation.constant.UserRole;
import com.donation.constant.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username; // 사용자 이름
    private String email; // 이메일
    private String password; // 비밀번호
    private String firstName; // 이름
    private String lastName; // 성

    @Enumerated(EnumType.STRING)
    private UserRole role; // 사용자 역할

    private LocalDateTime createdAt; // 계정 생성 날짜
    private LocalDateTime updatedAt; // 계정 수정 날짜

    @Enumerated(EnumType.STRING)
    private UserStatus status; // 계정 상태

    // 주소 정보
    private String address; // 주소
    private String city; // 도시
    private String postalCode; // 우편번호
    private String country; // 국가
}
