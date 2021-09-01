package form.listener;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.TaskListener;

public class ChooseReviewersListener implements JavaDelegate {

	private static final long serialVersionUID = 6958833163039319198L;

	public void execute(DelegateExecution execution) throws Exception {
		execution.setVariable("numberReviewersThatAccepted", 0);
		
		List<String> reviewersThatAccepted = new ArrayList<String>();
		execution.setVariable("reviewersThatAccepted", reviewersThatAccepted);
		
		execution.setVariable("numberOfFormalizationAccepted", 0);

	}

}
