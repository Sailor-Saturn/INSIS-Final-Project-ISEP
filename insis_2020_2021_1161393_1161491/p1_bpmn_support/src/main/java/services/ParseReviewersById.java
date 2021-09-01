package services;

import java.util.Arrays;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;

public class ParseReviewersById implements JavaDelegate {

	private static Log Log = LogFactory.getLog(ParseReviewersById.class);

	public void execute(DelegateExecution execution) throws Exception {
		Log.info("Parse reviewers by id...");
		
		String retrievedReviewers = execution.getVariable("retrievedReviewers").toString();
		
		String selectedReviewers = execution.getVariable("selectedReviewers").toString();
		
		Log.info("Retrieved reviewers");
		Log.info(retrievedReviewers);
		
		List<JsonEntryDTO> availableReviewersDTO = JsonEntryReader.readJsonEntry(retrievedReviewers);
		
		Log.info("retrieved reviewers DTO");
		Log.info(availableReviewersDTO);
		
		List<String> reviewersIdList = Arrays.asList(selectedReviewers.split(","));
		
		Log.info("Reviewers ID list");
		Log.info(reviewersIdList);
		
		List<JsonEntryDTO> chosenReviewersDTO = JsonEntryDTOHelper.retrieveJsonEntriesOfEntriesWithIds(availableReviewersDTO, reviewersIdList);
		
		Log.info("Number of chosen reviewers dtos");
		Log.info(chosenReviewersDTO.size());
		
		String chosenReviewersJSON = JsonEntryReader.jsonEntryToString(chosenReviewersDTO);
		
		Log.info("Chosen reviewers JSON");
		Log.info(chosenReviewersJSON);
		
		execution.setVariable("chosenReviewersJson", chosenReviewersJSON);
		
		List<String> chosenReviewersNames = JsonEntryDTOHelper.retrieveNameOfJsonEntriesWithIds(chosenReviewersDTO, reviewersIdList);
		
		Log.info("Chosen reviewers names");
		Log.info(chosenReviewersNames);
		execution.setVariable("chosenReviewersNames", chosenReviewersNames);
		
		List<String> chosenReviewersUsernames = JsonEntryDTOHelper.retrieveUsernamesOfJsonEntryWithIds(chosenReviewersDTO, reviewersIdList);
		Log.info("Chosen reviewers usernames");
		Log.info(chosenReviewersUsernames);
		
		List<String> chosenReviewersEmails = JsonEntryDTOHelper.retrieveEmailsOfJsonEntryWithIds(chosenReviewersDTO, reviewersIdList);
		Log.info("Chosen reviewers emails");
		Log.info(chosenReviewersEmails);
		
		execution.setVariable("chosenReviewersEmails", chosenReviewersEmails);
		
		execution.setVariable("chosenReviewersUsernames", chosenReviewersUsernames);
		
		execution.setVariable("numberOfChosenReviewers", chosenReviewersUsernames.size());
	}

}
