package com.insis.defense.cmd.service;

import com.insis.defense.cmd.domain.Defense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DefenseService {

    Defense getDefenseById(String defenseId);

    List<Defense> getAllDefenses(String defenseStatus);

    Defense createDefense(Defense defense) throws Exception;
}
