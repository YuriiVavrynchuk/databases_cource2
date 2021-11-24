package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.OrderDTO;
import com.yvavrynchuk.domain.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends AbstractMapper<OrderEntity, OrderDTO> {

    @Override
    public OrderDTO mapObjectToDTO(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }

        OrderDTO.OrderDTOBuilder orderDTOBuilder = OrderDTO.builder();
        orderDTOBuilder.id(orderEntity.getId());
        orderDTOBuilder.orderDatetime(orderEntity.getOrderDatetime());
        orderDTOBuilder.client(orderEntity.getClient());
        orderDTOBuilder.price(orderEntity.getPrice());
        orderDTOBuilder.amountOfAnimators(orderEntity.getAmountOfAnimators());
        orderDTOBuilder.subject(orderEntity.getSubject());
        orderDTOBuilder.eventId(orderEntity.getEventId());
        orderDTOBuilder.clientAccountId(orderEntity.getClientAccountId());
        orderDTOBuilder.animatorsAgencyBusinessId(orderEntity.getAnimatorsAgencyBusinessId());

        return orderDTOBuilder.build();
    }
}
