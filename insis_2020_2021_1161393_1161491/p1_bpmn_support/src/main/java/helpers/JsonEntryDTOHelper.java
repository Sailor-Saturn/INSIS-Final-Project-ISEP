package helpers;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dto.JsonEntryDTO;

public class JsonEntryDTOHelper {
	
	private static Log Log = LogFactory.getLog(JsonEntryDTOHelper.class);
	
	public static String retrieveIdOfJsonEntryWithUsername(List<JsonEntryDTO> jsonEntries, String username) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.getUsername().equals(username)) {
				return dto.getId();
			}
		}
		
		return null;
	}

	public static String retrieveNameOfJsonEntryWithId(List<JsonEntryDTO> jsonEntries, String id) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.hasId(id)) {
				return dto.getName();
			}
		}
		
		return null;
	}
	
	public static String retrieveUsernameOfJsonEntryWithEmail(List<JsonEntryDTO> jsonEntries, String email) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.getEmail().equals(email)) {
				return dto.getUsername();
			}
		}
		
		return null;
	}
	
	public static String retrieveEmailOfJsonEntryWithId(List<JsonEntryDTO> jsonEntries, String id) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.hasId(id)) {
				return dto.getEmail();
			}
		}
		
		return null;
	}
	
	public static String retrieveEmailOfJsonEntryWithUsername(List<JsonEntryDTO> jsonEntries, String username) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.getUsername().equals(username)) {
				return dto.getEmail();
			}
		}
		
		return null;
	}
	
	public static List<String> retrieveEmailsOfJsonEntryWithIds(List<JsonEntryDTO> jsonEntries, List<String> ids) {
		
		List<String> emailsList = new ArrayList<String>();
		for (String id: ids) {
			String foundEmail = retrieveEmailOfJsonEntryWithId(jsonEntries, id);
			
			if (foundEmail != null) {
				emailsList.add(foundEmail);
			}
		}
		
		return emailsList;
	}
	
	
	public static String retrieveUsernameOfJsonEntryWithId(List<JsonEntryDTO> jsonEntries, String id) {
		
		for (JsonEntryDTO dto: jsonEntries) {
			if (dto.hasId(id)) {
				return dto.getUsername();
			}
		}
		
		return null;
	}
	
	public static List<String> retrieveUsernamesOfJsonEntryWithIds(List<JsonEntryDTO> jsonEntries, List<String> ids) {
		
		List<String> usernamesList = new ArrayList<String>();
		for (String id: ids) {
			String foundUsername = retrieveUsernameOfJsonEntryWithId(jsonEntries, id);
			
			if (foundUsername != null) {
				usernamesList.add(foundUsername);
			}
		}
		
		return usernamesList;
	}
	
	public static List<String> retrieveNameOfJsonEntriesWithIds(List<JsonEntryDTO> jsonEntries, List<String> ids) {
		List<String> listOfNames = new ArrayList<String>();	
		
		for (String id: ids) {
			listOfNames.add(retrieveNameOfJsonEntryWithId(jsonEntries, id));
		}
		
		return listOfNames;
	}
	
	public static List<JsonEntryDTO> retrieveJsonEntriesOfEntriesWithIds(List<JsonEntryDTO> jsonEntries, List<String> ids) {
		List<JsonEntryDTO> listOfEntries = new ArrayList<JsonEntryDTO>();	
		Log.info("ids list");
		Log.info(ids);
		
		for (JsonEntryDTO entry: jsonEntries) {
			Log.info("entry ID");
			Log.info(entry.getId());
			if (ids.contains(entry.getId())) {
				listOfEntries.add(entry);
			}
		}
		
		return listOfEntries;
	}
}
