package com.example.web.dto;

import lombok.Getter;

@Getter
public class FileUploadResponse {

    private String key;

    public FileUploadResponse(String key){
        this.key = key;
    }
}
