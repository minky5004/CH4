package com.example.domain.service;

import com.example.domain.entity.Member;
import com.example.domain.repository.MemberRepository;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Template s3Template;
    private final MemberRepository memberRepository;

    @Value("${s3-bucket}")
    private String bucket;

    private static final Duration SIGNED_URL_DURATION = Duration.ofDays(7);

    @Transactional
    public String uploadAndUpdateMember(Long memberId, MultipartFile file) {
        try {

            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. ID: " + memberId));

            String key = "profiles/" + memberId + "/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());


            member.setProfileImageUrl(key);

            return key;
        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 중 오류 발생", e);
        }
    }

    @Transactional(readOnly = true)
    public String getMemberPresignedUrl(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. ID: " + memberId));

        String key = member.getProfileImageUrl();
        if (key == null || key.isBlank()) {
            throw new IllegalStateException("등록된 프로필 이미지가 없습니다.");
        }

        return s3Template.createSignedGetURL(bucket, key, SIGNED_URL_DURATION).toString();
    }
}