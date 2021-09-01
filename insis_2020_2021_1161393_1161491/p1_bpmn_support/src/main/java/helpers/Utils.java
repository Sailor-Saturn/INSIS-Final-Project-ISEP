package helpers;

import java.util.Arrays;
import java.util.List;

import org.activiti.engine.delegate.DelegateTask;
import org.apache.commons.logging.Log;

import dto.JsonEntryDTO;

public class Utils {
	
	public static void setVariableOfChosenItems(Log Log, DelegateTask execution, String availableItemsVarName, String chosenItemsVarName, String variableToSetName,
			String variableToSetJoinedString) {
		String retrievedItems = execution.getVariable(availableItemsVarName).toString();
		
		Log.info("retrieved " + chosenItemsVarName);
		Log.info(retrievedItems);
		
		List<JsonEntryDTO> retrievedItemsDTOs = JsonEntryReader.readJsonEntry(retrievedItems);

		Log.info(retrievedItemsDTOs);
		
		String chosenItemsString = (String) execution.getVariable(chosenItemsVarName);
		
		// No items chosen... Nothing to do
		if (chosenItemsString == null)  {
			return;
		}
		
		List<String> chosenItems = Arrays.asList((chosenItemsString.split(",")));
		Log.info(chosenItems.toString());
		
		List<String> chosenItemsNames = JsonEntryDTOHelper.retrieveNameOfJsonEntriesWithIds(retrievedItemsDTOs, chosenItems);
		
		String chosenItemsNamesAsString = String.join(",", chosenItemsNames);

		execution.setVariable(variableToSetName, chosenItemsNames);
		
		if (variableToSetJoinedString != null) {
			execution.setVariable(variableToSetJoinedString, chosenItemsNamesAsString);
		}
	}

}
