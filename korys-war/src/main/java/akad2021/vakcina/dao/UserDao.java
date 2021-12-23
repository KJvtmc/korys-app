package akad2021.vakcina.dao;

import java.util.List;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import akad2021.vakcina.users.User;


public interface UserDao extends JpaRepository<User, Long>{


	
}
