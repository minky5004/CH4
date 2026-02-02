package com.example.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequest {
    private String name;
    private int age;
    private String mbti;
}