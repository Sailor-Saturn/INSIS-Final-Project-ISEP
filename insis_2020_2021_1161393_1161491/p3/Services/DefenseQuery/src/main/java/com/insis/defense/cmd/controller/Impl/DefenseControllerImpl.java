package com.insis.defense.cmd.controller.Impl;

import com.insis.defense.cmd.controller.DefenseController;
import com.insis.defense.cmd.controller.dto.response.DefenseResponseDTO;
import com.insis.defense.cmd.controller.dtos.CreateDefenseDTO;
import com.insis.defense.cmd.controller.mapper.DefenseMapper;
import com.insis.defense.cmd.domain.Defense;
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

import java.util.List;

@RestController
@RequestMapping("/api/q/defense")
public class DefenseControllerImpl implements DefenseController {

    @Autowired
    private DefenseService defenseService;

    @Override
    @Operation(summary = "Formalize a defense.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Defense created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Defense.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createDefense(@RequestBody CreateDefenseDTO createDefenseDTO) {
        Defense defense = DefenseMapper.fromDtoToDomain(createDefenseDTO);
        try {
            Defense defense1 = defenseService.createDefense(defense);
            DefenseResponseDTO responseDTO = DefenseMapper.fromDomainToDTO(defense1);
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    @Operation(summary = "Get a defense by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Defense",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DefenseResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Defenses not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(String defenseId) {
        try{
            Defense defense = defenseService.getDefenseById(defenseId);
            DefenseResponseDTO defenseResponseDTO = DefenseMapper.fromDomainToDTO(defense);
            return ResponseEntity.ok(defenseResponseDTO);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    @Operation(summary = "Get a list of all defenses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the defenses",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DefenseResponseDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Defenses not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(@Parameter(description = "Retrieve only proposals of this status.") @RequestParam(required = false) String defenseStatus) {
        try {
            List<Defense> defenseList = defenseService.getAllDefenses(defenseStatus);
            List<DefenseResponseDTO> responseDTOList = DefenseMapper.fromDomainsToDTOs(defenseList);
            return ResponseEntity.ok(responseDTOList);
        }catch (IllegalArgumentException exception){
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
