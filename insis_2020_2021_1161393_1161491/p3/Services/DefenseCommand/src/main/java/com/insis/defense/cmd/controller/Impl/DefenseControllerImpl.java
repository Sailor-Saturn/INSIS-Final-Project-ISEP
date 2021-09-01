package com.insis.defense.cmd.controller.Impl;

import com.insis.defense.cmd.controller.DefenseController;
import com.insis.defense.cmd.controller.dto.response.DefenseResponseDTO;
import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import com.insis.defense.cmd.controller.mapper.DefenseMapper;
import com.insis.defense.cmd.controller.mapper.DefenseStatusMapper;
import com.insis.defense.cmd.domain.Defense;
import com.insis.defense.cmd.domain.DefenseStatus;
import com.insis.defense.cmd.service.DefenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/defense")
public class DefenseControllerImpl implements DefenseController {

    @Autowired
    private DefenseService defenseService;

    @Override
    @Operation(summary = "Create a defense with no jury.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Defense created.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Defense.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error.",
                    content = @Content)})
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createDefense(CreateDefenseDTO createDefense) {
        Defense defense = DefenseMapper.fromDtoToDomain(createDefense);
        try {
            defenseService.createDefense(defense);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @Override
    @Operation(summary = "Set defense status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Defense status changed.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Defense.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content)})
    @RequestMapping(value = "/defenseStatus/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> setDefenseStatus(@Parameter(description = "defense status to be set") String defenseStatus,
                                              @Parameter(description = "id of defense  to be searched") @PathVariable("id") String defenseId) {

        try {
            DefenseStatus defenseStatus1 = DefenseStatusMapper.stringToStatus(defenseStatus);
            Defense updateDefense =  defenseService.updateDefenseStatus(defenseStatus1,defenseId);
            DefenseResponseDTO defenseResponseDTO = DefenseMapper.fromDomainToDTO(updateDefense);
            return ResponseEntity.ok(defenseResponseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    @Operation(summary = "Set jury to the defense")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Jury has been set.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Defense.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/jury/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> setJury(@Parameter(description = "id of the jury")
                                         @PathVariable String juryId) {
        return null;
    }

    @Override
    @Operation(summary = "Delete a defense.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Defense deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    public void deleteDefense() {
        //TODO
    }
}
