package services;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryReader;

public class ParseUsersToNotify implements JavaDelegate {

	private static Log Log = LogFactory.getLog(ParseUsersToNotify.class);

	public void execute(DelegateExecution execution) throws Exception {
		Log.info("Parse users to notify...");

		String usersToNotifyString = execution.getVariable("users").toString();
		
		Log.info("Users to notify string");
		Log.info(usersToNotifyString);
		
		List<JsonEntryDTO> usersAvailable = JsonEntryReader.readJsonEntry(usersToNotifyString);
		
		List<String> usersEmails = new ArrayList<String>();
		
		for (JsonEntryDTO user: usersAvailable) {
			usersEmails.add(user.getEmail());
		}
		
		Log.info("Users emails");
		Log.info(usersEmails);
		
		execution.setVariable("usersEmails", usersEmails);
	}

}
