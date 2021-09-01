package com.insis.proposal.cmd.controller;

import com.insis.proposal.cmd.domain.Proposal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface FormalizationController {

    @Operation(summary = "Get a list of all formalizations a proposal. Filtering by status is possible.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Formalizations found.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAllFormalizations(@Parameter(description = "Retrieve only formalizations of this status.")
                                           @RequestParam(required = false) String formalizationStatus);

    @Operation(summary = "Get a formalization by its id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the formalization.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Proposal.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<?> findFormalizationById(@Parameter(description = "id of formalization to be searched") @PathVariable("id") String id);


}
