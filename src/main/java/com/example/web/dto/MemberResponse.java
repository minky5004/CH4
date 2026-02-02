package com.example.web.dto;

import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String name;
    private final int age;
    private final String mbti;

    public MemberResponse(com.example.domain.entity.Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
        this.mbti = member.getMbti();
    }
}