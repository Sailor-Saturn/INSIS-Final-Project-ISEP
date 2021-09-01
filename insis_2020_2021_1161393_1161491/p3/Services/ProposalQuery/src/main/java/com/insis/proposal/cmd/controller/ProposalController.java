package com.insis.proposal.cmd.controller;


import com.insis.proposal.cmd.controller.dtos.ProposalResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

public interface ProposalController {

    @Operation(summary = "Get a proposal by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the proposal",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProposalResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Proposal not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value="/{proposalId}", method = RequestMethod.GET)
    ResponseEntity<?> findById(@Parameter(description = "id of proposal to be searched")
                                        @PathVariable String proposalId);

    @Operation(summary = "Get a list of all proposals. Filtering by status is possible.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the proposals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProposalResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid status supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAllProposals(@Parameter(description = "Retrieve only proposals of this status.") @RequestParam(required = false) String proposalStatus);

    @Operation(summary = "Get all proposals of a proponent by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all the proponent proposals",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProposalResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value="/proponent/{proponentId}", method = RequestMethod.GET)
    ResponseEntity<?> getAllProposalsOfProponent(@Parameter(description = "Retrieve only proposals of this proponent.") @PathVariable String proponentId);

}
