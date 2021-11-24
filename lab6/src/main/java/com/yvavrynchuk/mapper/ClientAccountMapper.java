package com.yvavrynchuk.mapper;

import com.yvavrynchuk.DTO.ClientAccountDTO;
import com.yvavrynchuk.domain.ClientAccountEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountMapper extends AbstractMapper<ClientAccountEntity, ClientAccountDTO> {

    @Override
    public ClientAccountDTO mapObjectToDTO(ClientAccountEntity clientAccountEntity) {
        if (clientAccountEntity == null) {
            return null;
        }

        ClientAccountDTO.ClientAccountDTOBuilder clientAccountDTOBuilder = ClientAccountDTO.builder();
        clientAccountDTOBuilder.id(clientAccountEntity.getId());
        clientAccountDTOBuilder.name(clientAccountEntity.getName());
        clientAccountDTOBuilder.surname(clientAccountEntity.getSurname());
        clientAccountDTOBuilder.age(clientAccountEntity.getAge());
        clientAccountDTOBuilder.gender(clientAccountEntity.getGender());
        clientAccountDTOBuilder.phone(clientAccountEntity.getPhone());
        clientAccountDTOBuilder.email(clientAccountEntity.getEmail());
        clientAccountDTOBuilder.debt(clientAccountEntity.getDebt());
        clientAccountDTOBuilder.bonuses(clientAccountEntity.getBonuses());
        clientAccountDTOBuilder.blacklistPresence(clientAccountEntity.getBlacklistPresence());
        clientAccountDTOBuilder.animatorsAgencyBusinessId(clientAccountEntity.getAnimatorsAgencyBusinessId());

        return clientAccountDTOBuilder.build();
    }
}
