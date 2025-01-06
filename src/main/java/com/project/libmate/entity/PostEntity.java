package com.project.libmate.entity;

import com.project.libmate.common.PostState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.project.libmate.common.PostState.posting;

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
    private LocalDateTime delete_date; //관리자가 삭제한 시점이 들어옴 (3일 후 db 삭제를 위함)

    @Enumerated(EnumType.STRING)
    private PostState state= posting;

    public PostEntity() {}
}
