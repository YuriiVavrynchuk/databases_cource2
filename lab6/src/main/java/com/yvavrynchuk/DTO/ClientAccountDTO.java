package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientAccountDTO {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String gender;
    private String phone;
    private String email;
    private Integer debt;
    private Integer bonuses;
    private Byte blacklistPresence;
    private Integer animatorsAgencyBusinessId;
}
