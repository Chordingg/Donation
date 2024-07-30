package com.donation.entity;

import com.donation.constant.DonationStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "donation")
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title; // 제목

    private String content; // 내용

    private LocalDateTime regDate; // 등록일

    private LocalDateTime updateDate; // 수정일

    @Column(length = 255)
    private String thumbnail; // 썸네일

    private int interest; // 관심 (하트)

    private String category; // 카테고리

    private double targetAmount; // 목표 금액

    private double raisedAmount; // 모금된 금액

    @Enumerated(EnumType.STRING)
    private DonationStatus status; // 상태
}
