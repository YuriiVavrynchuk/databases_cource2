package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "order")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")

public class Order {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_datetime")
    private String order_datetime;

    @Column(name = "client")
    private String client;

    @Column(name = "price")
    private Integer price;

    @Column(name = "amount_of_animators")
    private Integer amount_of_animators;

    @Column(name = "subject")
    private String subject;

    @Column(name = "event_id")
    private Integer event_id;

    @Column(name = "client_account_id")
    private Integer client_account_id;

    @Column(name = "animators_agency_business_id")
    private Integer animators_agency_business_id;
}
