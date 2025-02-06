package com.project.libmate.entity;

import com.project.libmate.common.CommentType;
import com.project.libmate.common.ReserveState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Table(name= "comment")
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    private Long parent_id; //부모댓

    @ManyToOne
    @JoinColumn(referencedColumnName = "post_id")
    private PostEntity post_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private UserEntity user_id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime reg_date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CommentType comment_type;

    public CommentEntity() {}
}
