package com.project.libmate.service;

import com.project.libmate.entity.UserEntity;
import com.project.libmate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity user) {
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    public void validateDuplicateUser(UserEntity user) {
        UserEntity findUser= userRepository.findByUserId(user.getUser_id());
        UserEntity findPhoneNumber= userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findUser!=null) {
            throw new IllegalStateException("이미 가입된 회원입니다."); //가입된 학번 존재
        }
        else if(findPhoneNumber!=null) {
            throw new IllegalStateException("이미 가입된 전화번호입니다.");
        }
    }
}
