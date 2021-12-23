package akad2021.vakcina.users;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import akad2021.vakcina.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	

	@Transactional(readOnly = true)
	public List<UserFromService> getUsers() {

		return userDao.findAll().stream()
				.map(user -> new UserFromService(user.getId(),user.getFirstName(),user.getLastName()))
				.collect(Collectors.toList()); 
	}
	@Transactional
	public void setUser(UserFromService userFromService) {
		var user = new User(userFromService.getId(),userFromService.getFirstName(),userFromService.getLastName());
		userDao.save(user);
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
