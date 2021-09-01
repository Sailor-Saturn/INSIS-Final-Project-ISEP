package com.insis.proposal.cmd.infrastructure.glue;

import com.insis.proposal.cmd.infrastructure.dto.ProposalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "insis.proposal.query", decode404 = true)
public interface ProposalGlue {

/*    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<ProposalDTO> getAllProposals();*/

    @RequestMapping(method = RequestMethod.GET, value = "/{proposalId}")
    ProposalDTO findById(@PathVariable("proposalId") String proposalId);

}
