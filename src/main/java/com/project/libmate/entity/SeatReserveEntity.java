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

    @OneToOne //회원탈퇴 로직에서 DB를 통해서 동일한 user_id 튜플 삭제 처리
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private UserEntity user_id;

    @OneToOne //즉시 로딩(seatEntity도 함께 로딩됨) 좌석번호(seatNumber), 층수 알기 위함, 변경/삭제될 일 없어서 cascade는 필요 X
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
