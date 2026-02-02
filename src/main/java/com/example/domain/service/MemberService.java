package com.example.domain.service;

import com.example.domain.entity.Member;
import com.example.domain.repository.MemberRepository;
import com.example.web.dto.MemberResponse;
import com.example.web.dto.MemberSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequest request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMbti());
        return memberRepository.save(member).getId();
    }

    @Transactional(readOnly = true)
    public MemberResponse findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 팀원이 존재하지 않습니다"));
        return new MemberResponse(member);

    }
}

