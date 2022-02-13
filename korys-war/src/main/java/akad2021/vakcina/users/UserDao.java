package akad2021.vakcina.users;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User, Long>{

	User findByUsername(String username);

	void deleteByUsername(String username);

//	@Query("SELECT new User(u.userId, u.username) FROM User u")
//	Page<User> findAll(Pageable pageable);
	
}
