package com.insis.defense.cmd.controller.mapper;

import com.insis.defense.cmd.controller.dto.response.DefenseResponseDTO;
import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import com.insis.defense.cmd.domain.Defense;

import java.util.UUID;

public class DefenseMapper {

    public static Defense fromDtoToDomain(CreateDefenseDTO createDefense){
        Defense defense = new Defense();

        defense.setDefenseId(UUID.randomUUID().toString());
        defense.setUserId(createDefense.getUserId());
        defense.setTitle(createDefense.getTitle());
        defense.setDefenseStatus(DefenseStatusMapper.stringToStatus(createDefense.getDefenseStatus()));

        return defense;
    }

    public static DefenseResponseDTO fromDomainToDTO(Defense defense) {
        DefenseResponseDTO defenseResponseDTO = new DefenseResponseDTO();

        defenseResponseDTO.setDefenseId(defense.getDefenseId());
        defenseResponseDTO.setDefenseStatus(DefenseStatusMapper.statusToString(defense.getDefenseStatus()));
        defenseResponseDTO.setTitle(defense.getTitle());
        defenseResponseDTO.setUserId(defense.getUserId());
        defenseResponseDTO.setJuryId(defense.getJuryId());

        return defenseResponseDTO;
    }
}
