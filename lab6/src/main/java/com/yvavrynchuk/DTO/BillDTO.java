package com.yvavrynchuk.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDTO {
    private Integer id;
    private String client;
    private Timestamp billDatetime;
    private Integer animatorsNumber;
    private Integer perfomanceDuration;
    private String price;
    private String organizer;
    private Integer orderId;
}
