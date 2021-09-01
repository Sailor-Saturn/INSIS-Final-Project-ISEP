package form.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;
import helpers.Utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;

public class SubmitProposalListener implements TaskListener {

	private static final long serialVersionUID = -5188826337400176087L;
	
	private static Log Log = LogFactory.getLog(SubmitProposalListener.class);
	
	private final String SELECTED_TECHNOLOGIES = "selectedTechnologies";
	private final String SELECTED_TECHNOLOGIES_STRING = "selectedTechnologiesString";
	
	private final String SELECTED_KEYWORDS = "selectedKeywords";
	private final String SELECTED_KEYWORDS_STRING = "selectedKeywordsString";

	private final String SELECTED_APPROACHES = "selectedApproaches";
	private final String SELECTED_APPROACHES_STRING = "selectedApproachesString";
	
	public void notify(DelegateTask execution) {
		
		Log.info("Submit proposal listener info...");
		
		Log.info("Setting technologies chosen items...");
		Utils.setVariableOfChosenItems(Log, execution, "retrievedTechnologies", "technologies", SELECTED_TECHNOLOGIES, SELECTED_TECHNOLOGIES_STRING);
		
		Log.info("Setting keywords chosen items...");
		Utils.setVariableOfChosenItems(Log, execution, "retrievedKeywords", "keywords", SELECTED_KEYWORDS, SELECTED_KEYWORDS_STRING);
		
		Log.info("Setting approaches chosen items...");
		Utils.setVariableOfChosenItems(Log, execution, "retrievedApproaches", "approaches", SELECTED_APPROACHES, SELECTED_APPROACHES_STRING);
		
		Log.info("Setting proponent username...");		
		String proponentUsername = execution.getAssignee();
		Log.info("Proponent username...");
		Log.info(proponentUsername);
		execution.setVariable("proponentUsername", proponentUsername);

	}

}
