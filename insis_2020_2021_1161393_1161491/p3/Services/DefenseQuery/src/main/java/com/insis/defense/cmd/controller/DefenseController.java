package com.insis.defense.cmd.controller;

import com.insis.defense.cmd.controller.dto.response.DefenseResponseDTO;
import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DefenseController {
    ResponseEntity<?> createDefense(@RequestBody CreateDefenseDTO createDefenseDTO);

    ResponseEntity<?> findById(@Parameter(description = "id of defense to be searched") @PathVariable String defenseId);

    ResponseEntity<?> findAll(@Parameter(description = "Retrieve only proposals of this status.") @RequestParam(required = false) String defenseStatus);
}
