package com.example.web;

import com.example.domain.service.MemberService;
import com.example.domain.service.S3Service;
import com.example.web.dto.FileDownloadResponse;
import com.example.web.dto.FileUploadResponse;
import com.example.web.dto.MemberResponse;
import com.example.web.dto.MemberSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final S3Service s3Service;

    @PostMapping
    public Long saveMember(@RequestBody MemberSaveRequest request) {
        return memberService.save(request);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<FileUploadResponse> uploadProfileImage(
            @PathVariable("id") Long id,
            @RequestParam("file") MultipartFile file) {

        String s3Key = s3Service.uploadAndUpdateMember(id, file);

        return ResponseEntity.ok(new FileUploadResponse(s3Key));
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<FileDownloadResponse> getProfileImage(@PathVariable("id") Long id) {

        String presignedUrl = s3Service.getMemberPresignedUrl(id);

        return ResponseEntity.ok(new FileDownloadResponse(presignedUrl));
    }
}
