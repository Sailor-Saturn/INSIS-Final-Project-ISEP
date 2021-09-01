package com.insis.defense.cmd.infrastructure.glue;

import com.insis.defense.cmd.infrastructure.dto.DefenseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "insis.defense.query", decode404 = true)
public interface DefenseGlue {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    DefenseDTO findDefenseById(@PathVariable("id") String defenseId);
}
