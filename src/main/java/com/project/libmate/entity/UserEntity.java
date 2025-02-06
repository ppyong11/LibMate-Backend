package com.project.libmate.entity;

import com.project.libmate.common.UserRole;
import com.project.libmate.dto.UserSignInDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.project.libmate.common.UserRole.user;

@AllArgsConstructor
@Getter
@Setter
@Table(name= "user")
@Entity
public class UserEntity {
    @Id
    @Column(name="id")
    private String user_id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String penalty;

    public UserEntity(){
        //기본 생성자
    }

    //DTO의 데이터를 기반으로 Entity를 생성함
    public static UserEntity createUser(UserSignInDto userSignInDto,
                                        PasswordEncoder passwordEncoder){
        UserEntity userEntity = new UserEntity();
        userEntity.setUser_id(userSignInDto.getId());
        userEntity.setPw(passwordEncoder.encode(userSignInDto.getPw()));
        userEntity.setName(userSignInDto.getName());
        userEntity.setPhoneNumber(userSignInDto.getPhoneNumber());
        userEntity.setRole(user);
        userEntity.setPenalty("0");
        return userEntity;
    }
}
