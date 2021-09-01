package form.listener;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FireProposalListener implements JavaDelegate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Log Log = LogFactory.getLog(FireProposalListener.class);

	@SuppressWarnings("unchecked")
	public void execute(DelegateExecution execution) throws Exception {
		List<String> keywords = (List<String>)execution.getVariable("keywords");
		
		Log.info("keywords list");
		Log.info(keywords);
		
		List<String> newKeywords = new ArrayList<String>();
		for (String keyword : keywords) {
			String newKeyword= "\"" + keyword + "\"";
			newKeywords.add(newKeyword);
		}
		
		Log.info("new keywords list");
		Log.info(newKeywords);
		execution.setVariable("keywords", newKeywords);
		
		
		
		List<String> approaches = (List<String>)execution.getVariable("approaches");
		
		Log.info("approaches list");
		Log.info(approaches);
		
		List<String> newApproaches = new ArrayList<String>();
		for (String approach : approaches) {
			String newApproach = "\"" + approach + "\"";
			newApproaches.add(newApproach );
		}
		
		Log.info("new approaches list");
		Log.info(newApproaches);
		execution.setVariable("approaches", newApproaches);
		
		
		
		
		
		
		
		List<String> technologies = (List<String>)execution.getVariable("technologies");
		
		Log.info("technologies list");
		Log.info(technologies);
		
		List<String> newTechnologies = new ArrayList<String>();
		for (String technology : technologies) {
			String newTechnology = "\"" + technology + "\"";
			newTechnologies.add(newTechnology);
		}
		
		Log.info("new technologies list");
		Log.info(newTechnologies);
		execution.setVariable("technologies", newTechnologies);
	}

}
