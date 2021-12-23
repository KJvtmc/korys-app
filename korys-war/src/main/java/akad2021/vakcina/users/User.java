package akad2021.vakcina.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Entity
@Table(name = "pacientas")
public class User {
	
	@Id
	@Column(name = "asmKodas")
	@NotNull
	@Length(min = 8, max = 8)
	private Long id;
	@Column
	@NotNull
	@Length(min = 1, max = 30)
	private String firstName;
	@Column
	@NotNull
	@Length(min = 1, max = 30)
	private String lastName;

	
	public User() {
	}
	

	public User(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	@Qualifier("id")
	@Autowired
	public void setUserName(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@Qualifier("itemFirstName")
	@Autowired
	public void setFirstName(String price) {
		this.firstName = price;
	}

	public String getLastName() {
		return lastName;
	}

	@Qualifier("itemLastName")
	@Autowired
	public void setLastName(String quantity) {
		this.lastName = quantity;
	};
}
