package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "feedback")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")

public class Feedback {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "client")
    private String client;

    @Column(name = "date")
    private String date;

    @Column(name = "text")
    private String text;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "event_id")
    private Integer event_id;

    @Column(name = "client_account_id")
    private Integer client_account_id;
}
