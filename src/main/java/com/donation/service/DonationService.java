package com.donation.service;

import com.donation.entity.Donation;
import com.donation.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    private final String uploadDir = "src/main/resources/static/uploads/";

    public void saveDonation(Donation donation, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                // 고유한 파일 이름 생성
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path path = Paths.get(uploadDir + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, file.getBytes());
                donation.setThumbnail("/uploads/" + fileName); // 브라우저에서 접근 가능한 경로 설정
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        donation.setRegDate(LocalDateTime.now());
        donation.setUpdateDate(LocalDateTime.now());
        donationRepository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }
}
