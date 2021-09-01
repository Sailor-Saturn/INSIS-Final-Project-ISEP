package form.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import helpers.Utils;

public class SuggestJuryListener implements TaskListener {
	
	private static final long serialVersionUID = 1L;

	private final String SELECTED_TEACHERS = "selectedTeachers";
	
	private static Log Log = LogFactory.getLog(SubmitProposalListener.class);
	

	public void notify(DelegateTask execution) {
		Log.info("Suggested jury listener info...");
		
		Log.info("Setting chosen teachers...");
		Utils.setVariableOfChosenItems(Log, execution, "retrievedTeachers", "teachers", SELECTED_TEACHERS, null);
		
	}

}
