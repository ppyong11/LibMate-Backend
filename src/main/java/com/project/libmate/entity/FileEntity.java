package com.project.libmate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Table(name= "file")
@Entity
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long file_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "post_id")
    private PostEntity post_id;

    @Column(nullable = false)
    private String file_name;

    @Column(nullable = false)
    private LocalDateTime reg_date;

    public FileEntity() {}
}
