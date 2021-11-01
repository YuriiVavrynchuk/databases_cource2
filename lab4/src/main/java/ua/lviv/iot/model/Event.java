package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "event")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")

public class Event {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "subject")
    private String subject;

    @Column(name = "guests_number")
    private Integer guests_number;

    @Column(name = "address")
    private String address;

    @Column(name = "date_start")
    private String date_start;

    @Column(name = "date_end")
    private String date_end;

    @Column(name = "time_start")
    private String time_start;

    @Column(name = "time_end")
    private String time_end;
}
