package com.insis.proposal.cmd.controller;

import com.insis.proposal.cmd.controller.dtos.CreateProposalDTO;
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


public interface ProposalController {

    @Operation(summary = "Create a proposal.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Proposal created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> createProposal(@RequestBody CreateProposalDTO proposalRequest);

    @Operation(summary = "Update a proposal.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proposal updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<?> updateProposal(@RequestBody UpdateProposalDTO updateProposalDTO,
                                     @Parameter(description = "id of proposal to be updated") @PathVariable("id") String id);

    @Operation(summary = "Update a proposal status.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proposal updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    ResponseEntity<?> updateProposalStatus(@Parameter(description = "The new proposal status") @RequestBody String newProposalStatus,
                                                  @Parameter(description = "id of proposal to be updated") @PathVariable("id") String id);

    @Operation(summary = "Delete a proposal.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Proposal deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteProposal(@Parameter(description = "id of proposal to be deleted") @PathVariable("id") String id);
}
