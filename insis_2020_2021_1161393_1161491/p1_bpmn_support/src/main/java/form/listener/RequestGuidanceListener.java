package form.listener;

import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;
import helpers.JsonEntryDTOHelper;
import helpers.JsonEntryReader;

public class RequestGuidanceListener implements TaskListener {

	private static Log Log = LogFactory.getLog(RequestGuidanceListener.class);

	private static final long serialVersionUID = -1881769348159852920L;

	public void notify(DelegateTask execution) {
		String retrievedTeachers = execution.getVariable("retrievedTeachers").toString();
		
		List<JsonEntryDTO> retrievedTeachersDTO = JsonEntryReader.readJsonEntry(retrievedTeachers);

		Log.info("retrieved teachers");
		Log.info(retrievedTeachersDTO);
		
		String selectedTeacher = execution.getVariable("selectedTeacher").toString();
		Log.info("selected teacher");
		Log.info(selectedTeacher);
		
		String teacherUsername = JsonEntryDTOHelper.retrieveUsernameOfJsonEntryWithId(retrievedTeachersDTO, selectedTeacher);
		Log.info("teacher username");
		Log.info(teacherUsername);
		execution.setVariable("selectedTeacherUsername", teacherUsername);
		
		String teacherName = JsonEntryDTOHelper.retrieveNameOfJsonEntryWithId(retrievedTeachersDTO, selectedTeacher);
		Log.info("teacher name");
		Log.info(teacherName);
		execution.setVariable("selectedTeacherName", teacherName);

		String teacherEmail = JsonEntryDTOHelper.retrieveEmailOfJsonEntryWithId(retrievedTeachersDTO, selectedTeacher);
		Log.info("teacher email");
		Log.info(teacherEmail);
		execution.setVariable("selectedTeacherEmail", teacherEmail);
		
	}

}
