package com.insis.defense.cmd.controller.mapper;

import com.insis.defense.cmd.controller.dto.response.DefenseResponseDTO;
import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import com.insis.defense.cmd.domain.Defense;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class DefenseMapper {

    public static Defense fromDtoToDomain(CreateDefenseDTO createDefense){
        Defense defense = new Defense();

        defense.setDefenseId(UUID.randomUUID().toString());
        defense.setUserId(createDefense.getUserId());
        defense.setTitle(createDefense.getTitle());
        defense.setDefenseStatus(DefenseStatusMapper.stringToStatus(createDefense.getDefenseStatus()));
        // No jury when creating a defense

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

    public static List<DefenseResponseDTO> fromDomainsToDTOs(List<Defense> defenseList) {
        List<DefenseResponseDTO> defenseResponseDTOS = new LinkedList<>();
        defenseList.forEach(defense -> {
            defenseResponseDTOS.add(fromDomainToDTO(defense));
        });
        return defenseResponseDTOS;
    }
}
