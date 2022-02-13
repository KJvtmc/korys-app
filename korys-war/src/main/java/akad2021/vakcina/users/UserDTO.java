package akad2021.vakcina.users;

public class UserDTO {
	
	private Long userId;
	private String username;
	private String password;
	
	public UserDTO() {
	}
	

	public UserDTO(Long userId, String usernameame, String password) {
		super();
		this.userId = userId;
		this.username = usernameame;
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
