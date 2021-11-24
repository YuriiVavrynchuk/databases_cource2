package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {
    private Integer id;
    private String title;
    private String subject;
    private Integer guestsNumber;
    private String address;
    private Timestamp dateStart;
    private Timestamp dateEnd;
    private Time timeStart;
    private Time timeEnd;
}
