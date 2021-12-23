package akad2021.vakcina.users;

public class UserFromService {
	
	private Long id;
	private String firstName;
	private String lastName;

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public UserFromService(Long id) {
		super();
		this.id = id;
	}

	public UserFromService(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	
}
