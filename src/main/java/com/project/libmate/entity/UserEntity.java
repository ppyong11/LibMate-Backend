package com.project.libmate.entity;

import com.project.libmate.common.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

    @Enumerated(EnumType.STRING)
    private UserRole role= user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    private String penalty;

    public UserEntity(){
        //기본 생성자
    }
}
