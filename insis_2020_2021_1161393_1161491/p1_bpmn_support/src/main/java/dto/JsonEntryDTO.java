package dto;

public class JsonEntryDTO {
	private String id;
	private String name;
	private String email;
	private String username;
	
	public JsonEntryDTO() {
	
	}
	
	public boolean hasId(String id) {
		return this.id.equals(id);
	}
	
	public String getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "id: " + String.valueOf(id) + "\n" + "name: " + name;
	}
	
}
