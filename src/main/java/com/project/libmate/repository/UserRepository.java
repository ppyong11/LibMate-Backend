package com.project.libmate.repository;

import com.project.libmate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    //중복 학번, 학번으로 유저 찾기, 비밀번호 찾기에 사용
    UserEntity findByUserId(String user_id);
    //중복 휴대폰 번호 확인
    UserEntity findByPhoneNumber(String phone_number);
}
