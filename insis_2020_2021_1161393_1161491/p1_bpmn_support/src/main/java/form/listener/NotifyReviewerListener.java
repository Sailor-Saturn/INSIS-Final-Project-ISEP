package form.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;

public class NotifyReviewerListener implements TaskListener {

	private static final long serialVersionUID = 1L;
	private static Log Log = LogFactory.getLog(NotifyReviewerListener.class);

	public void notify(DelegateTask execution) {
		
		String listOfReviewers = execution.getVariable("retrievedReviewers").toString();
		List<JsonEntryDTO> reviewersDTO = JsonEntryReader.readJsonEntry(listOfReviewers);
		
		Log.info("reviewer username");
		String reviewerUsername = execution.getVariable("reviewerUsername").toString();
		Log.info(reviewerUsername);
		
		String emailOfReviewer = JsonEntryDTOHelper.retrieveEmailOfJsonEntryWithUsername(reviewersDTO, reviewerUsername);

		Log.info("reviewer email");
		Log.info(emailOfReviewer);
		execution.setVariable("reviewerEmail", emailOfReviewer);
	}

}
