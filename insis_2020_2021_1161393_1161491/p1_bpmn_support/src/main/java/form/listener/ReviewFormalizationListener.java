package form.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class ReviewFormalizationListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2232241045678058941L;

	public void notify(DelegateTask execution) {
		String reviewFormalizationAccepted = execution.getVariable("reviewFormalizationAccept").toString();
		
		int numberOfAccepted = 0;
		
		if (execution.hasVariable("numberOfFormalizationAccepted")) {
			numberOfAccepted = (Integer) execution.getVariable("numberOfFormalizationAccepted");
		}
		
		if (reviewFormalizationAccepted.equals("true")) {
			numberOfAccepted++;
			
			execution.setVariable("numberOfFormalizationAccepted", numberOfAccepted);
		}
		
	}

}
