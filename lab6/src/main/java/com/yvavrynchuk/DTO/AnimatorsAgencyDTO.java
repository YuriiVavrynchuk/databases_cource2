package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimatorsAgencyDTO {
    private Integer businessId;
    private String name;
    private String address;
    private Integer workersNumber;
    private String license;
    private String bankAccount;
    private Integer registrationCountry;
}
