package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.BillDTO;
import com.yvavrynchuk.domain.BillEntity;
import org.springframework.stereotype.Component;

@Component
public class BillMapper extends AbstractMapper<BillEntity, BillDTO> {

    @Override
    public BillDTO mapObjectToDTO(BillEntity billEntity) {
        if (billEntity == null) {
            return null;
        }

        BillDTO.BillDTOBuilder billDTOBuilder = BillDTO.builder();
        billDTOBuilder.id(billEntity.getId());
        billDTOBuilder.client(billEntity.getClient());
        billDTOBuilder.billDatetime(billEntity.getBillDatetime());
        billDTOBuilder.animatorsNumber(billEntity.getAnimatorsNumber());
        billDTOBuilder.perfomanceDuration(billEntity.getPerfomanceDuration());
        billDTOBuilder.price(billEntity.getPrice());
        billDTOBuilder.organizer(billEntity.getOrganizer());
        billDTOBuilder.orderId(billEntity.getOrderId());

        return billDTOBuilder.build();
    }
}
