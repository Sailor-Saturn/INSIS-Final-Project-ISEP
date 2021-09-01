package com.insis.defense.cmd.service;

import com.insis.defense.cmd.domain.Defense;
import com.insis.defense.cmd.domain.DefenseStatus;
import org.springframework.stereotype.Service;

@Service
public interface DefenseService {

    Defense createDefense(Defense defense) throws Exception;

    Defense updateDefense(Defense defense, String defenseId) throws Exception;

    Defense updateDefenseStatus(DefenseStatus status, String id);

    boolean deleteDefense(long id);
}
