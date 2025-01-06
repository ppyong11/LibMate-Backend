package com.project.libmate.entity;

import com.project.libmate.common.ReserveState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Table(name= "seat_reserve")
@Entity
public class SeatReserveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserve_id;

    @OneToOne(cascade= CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private UserEntity user_id;

    @OneToOne(cascade= CascadeType.MERGE)
    @JoinColumn(referencedColumnName = "seat_id", nullable = false)
    private SeatEntity seat_id;

    private LocalDateTime reserve_date;
    private LocalDateTime use_date;

    @Column(name="state")
    @Enumerated(EnumType.STRING)
    private ReserveState reserve_state;

    public SeatReserveEntity() {
    }
}
