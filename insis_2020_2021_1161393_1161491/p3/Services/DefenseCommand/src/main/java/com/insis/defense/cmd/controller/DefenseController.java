package com.insis.defense.cmd.controller;

import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface DefenseController {

    ResponseEntity<?> createDefense(@RequestBody CreateDefenseDTO createDefenseDTO);
    ResponseEntity<?> setDefenseStatus(@Parameter(description = "defense status to be set") String defenseStatus,
                                       @Parameter(description = "id of defense  to be searched") @PathVariable String defenseId);
    ResponseEntity<?> setJury(@RequestBody String juryId);

    void deleteDefense();
}
