package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "animators_agency")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class AnimatorsAgency {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "workers_number")
    private Integer workers_number;

    @Column(name = "license")
    private String license;

    @Column(name = "bank_account")
    private Integer bank_account;

    @Column(name = "registration_country")
    private Integer registration_country;
}
