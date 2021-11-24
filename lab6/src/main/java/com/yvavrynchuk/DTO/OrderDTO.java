package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Integer id;
    private Timestamp orderDatetime;
    private String client;
    private Integer price;
    private Integer amountOfAnimators;
    private String subject;
    private Integer eventId;
    private Integer clientAccountId;
    private Integer animatorsAgencyBusinessId;
}
