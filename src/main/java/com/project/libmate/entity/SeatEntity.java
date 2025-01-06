package com.project.libmate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table(name= "seat")
@Entity
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seat_id;

    @Column(nullable = false)
    private String seat_number;

    @Column(nullable = false)
    private String seat_floor;

    public SeatEntity() {}
}
