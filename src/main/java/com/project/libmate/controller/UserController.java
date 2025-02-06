package com.project.libmate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/libmate")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/signin")
    public String signin(String id, String pw, String name, String phoneNumber) {
        logger.info("[UC] signin 값: " + id + ", " + pw + ", " + name + ", " + phoneNumber);
        return id; //나중에 수정
    }
}
