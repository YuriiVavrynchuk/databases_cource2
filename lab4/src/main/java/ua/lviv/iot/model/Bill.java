package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "bill")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Bill {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "client")
    private String client;

    @Column(name = "bill_datetime")
    private String bill_datetime;

    @Column(name = "animators_number")
    private Integer animators_number;

    @Column(name = "perfomance_duration")
    private Integer perfomance_duration;

    @Column(name = "price")
    private Integer price;

    @Column(name = "organizer")
    private String organizer;

    @Column(name = "order_id")
    private Integer order_id;
}
