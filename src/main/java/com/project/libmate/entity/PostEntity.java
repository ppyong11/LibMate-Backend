package com.project.libmate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
@Table(name= "post")
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "user_id", nullable = false)
    private UserEntity user_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private LocalDateTime reg_date;

    private LocalDateTime update_date;

    public PostEntity() {}
}
