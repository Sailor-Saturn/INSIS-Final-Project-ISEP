package form.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryReader;

public class PersistProposalComplete implements JavaDelegate {
	
	private static Log Log = LogFactory.getLog(PersistProposalComplete.class);

	public void execute(DelegateExecution execution) throws Exception {
		String generatedId = execution.getVariable("generatedid").toString();
		
		Log.info("generated id");
		Log.info(generatedId);
		
		JsonEntryDTO generatedIdDTO = JsonEntryReader.readSingleJSONEntry(generatedId);
		
		Log.info("generated id dtos");
		Log.info(generatedIdDTO);
		
		String id = generatedIdDTO.getId();
		
		Log.info("proposal id");
		Log.info(id);
		
		execution.setVariable("proposalid", id);
	}

}