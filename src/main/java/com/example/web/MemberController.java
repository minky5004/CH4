package com.example.web;

import com.example.domain.service.MemberService;
import com.example.web.dto.MemberResponse;
import com.example.web.dto.MemberSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Long saveMember(@RequestBody MemberSaveRequest request) {
        return memberService.save(request);
    }

    @GetMapping("/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.findById(id);
    }
}
