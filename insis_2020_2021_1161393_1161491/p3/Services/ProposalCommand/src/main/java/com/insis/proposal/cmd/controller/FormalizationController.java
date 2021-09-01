package com.insis.proposal.cmd.controller;

import com.insis.proposal.cmd.controller.dtos.CreateFormalizationDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateFormalizationDTO;
import com.insis.proposal.cmd.controller.dtos.UpdateProposalDTO;
import com.insis.proposal.cmd.domain.Proposal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface FormalizationController {

    @Operation(summary = "Formalize a proposal.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Formalization created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createFormalization(@RequestBody CreateFormalizationDTO formalizationRequest);

    @Operation(summary = "Update a formalization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formalization updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> updateFormalization(@RequestBody UpdateFormalizationDTO updateFormalizationDTO,
                                          @Parameter(description = "id of formalization to be updated") @PathVariable("id") String id);

    @Operation(summary = "Update a formalization status.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proposal updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/status/{id}", method = RequestMethod.PATCH)
    ResponseEntity<?> updateFormalizationStatus(@RequestBody String newFormalizationStatus,
                                                @Parameter(description = "id of formalization to be updated") @PathVariable("id") String id);

    @Operation(summary = "Delete a formalization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Formalization deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteFormalization(@Parameter(description = "id of formalization to be deleted") @PathVariable("id") String id);
}
