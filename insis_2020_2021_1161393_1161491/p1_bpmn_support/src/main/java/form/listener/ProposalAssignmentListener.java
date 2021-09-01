package form.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;

public class ProposalAssignmentListener implements TaskListener {

	private static Log Log = LogFactory.getLog(ProposalAssignmentListener.class);

	private static final long serialVersionUID = 3L;

	public void notify(DelegateTask execution) {
		Log.info("ProposalAssignmentListener");
		
		String retrievedStudents = execution.getVariable("retrievedStudents").toString();
		
		List<JsonEntryDTO> retrievedStudentsDTO = JsonEntryReader.readJsonEntry(retrievedStudents);

		Log.info("retrieved students");
		Log.info(retrievedStudentsDTO);
		
		String studentEmail = execution.getVariable("studentEmail").toString();
		Log.info("student email");
		Log.info(studentEmail);
		
		String studentUsername = JsonEntryDTOHelper.retrieveUsernameOfJsonEntryWithEmail(retrievedStudentsDTO, studentEmail);
		Log.info("student username");
		Log.info(studentUsername );
		
		execution.setVariable("studentUsername", studentUsername );
		
	}

}
