package com.dio.crud.reservadesala.reservadesala.model;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name="meetingRoom")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRoom;
    @Column(name="ROOM_COD",unique = true,nullable = false)
    private String codRoom;
    @Column(name="DATE",unique = true,nullable = false)
    private String date;
    @Column(name="START_HOUR",unique = true,nullable = false)
    private String starHour;
    @Column(name="END_HOUR",unique = true,nullable = false)
    private String endHour;
}
