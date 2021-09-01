package form.listener;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import dto.JsonEntryDTO;
import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;

public class AcceptReviewingAssignmentListener implements TaskListener {

	private static final long serialVersionUID = -3908355334907300745L;

	@SuppressWarnings("unchecked")
	public void notify(DelegateTask execution) {
		
		// Reviewer did not accept. Nothing to do...
		if (!execution.getVariable("acceptReviewingAssignment").toString().equals("true")) {
			return;
		}
		
		String reviewerUsername = execution.getAssignee();
		
		String listOfReviewers = execution.getVariable("retrievedReviewers").toString();
		
		List<JsonEntryDTO> reviewersDTO = JsonEntryReader.readJsonEntry(listOfReviewers);
		
		String idOfReviewer = JsonEntryDTOHelper.retrieveIdOfJsonEntryWithUsername(reviewersDTO, reviewerUsername);
		
		List<String> reviewers = new ArrayList<String>();
		
		if (execution.hasVariable("reviewersThatAccepted")) {
			reviewers = (List<String>) execution.getVariable("reviewersThatAccepted");
		}
		
		reviewers.add(idOfReviewer);
		
		execution.setVariable("reviewersThatAccepted", reviewers);
		execution.setVariable("numberReviewersThatAccepted", reviewers.size());
	}

}
