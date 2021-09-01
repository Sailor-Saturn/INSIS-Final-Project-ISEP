package dto;

import java.util.ArrayList;
import java.util.List;

public class TableEntriesDTO {

	List<TableEntryDTO> tableEntries;
	
	public TableEntriesDTO() {
		tableEntries = new ArrayList<TableEntryDTO>();
	}
	
	public void addTableEntry(String key, String value) {
		tableEntries.add(new TableEntryDTO(key, value));
	}
	
}
