package form.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AcceptProposalListener implements TaskListener {
	
	private static final long serialVersionUID = 1L;
	private static Log Log = LogFactory.getLog(AcceptProposalListener.class);

	public void notify(DelegateTask execution) {
		Log.info("Reseting student name and email.....");
		execution.setVariable("studentName", "" );
		execution.setVariable("studentEmail", "" );
	}

}
