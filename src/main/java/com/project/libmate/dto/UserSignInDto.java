package com.project.libmate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInDto {
    private String id;
    private String pw;
    private String name;
    private String phoneNumber;
}
