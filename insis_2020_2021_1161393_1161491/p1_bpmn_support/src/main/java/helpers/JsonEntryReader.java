package helpers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.JsonEntryDTO;

public class JsonEntryReader {
	private static Log Log = LogFactory.getLog(JsonEntryReader.class);
	
	public static JsonEntryDTO readSingleJSONEntry(String json) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.readValue(json, new TypeReference<JsonEntryDTO>() {});
		} catch (Exception e) {
			Log.info(e.getStackTrace());
		}
	
		return null;
	}

	public static List<JsonEntryDTO> readJsonEntry(String json) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.readValue(json, new TypeReference<List<JsonEntryDTO>>() {});
		} catch (Exception e) {
			Log.info(e.getStackTrace());
		}
	
		return null;
	}
	
	public static String jsonEntryToString(List<JsonEntryDTO> entries) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			return objectMapper.writeValueAsString(entries);
		} catch (Exception e) {
			Log.info(e.getStackTrace());
		}
	
		return null;	
	}

}
