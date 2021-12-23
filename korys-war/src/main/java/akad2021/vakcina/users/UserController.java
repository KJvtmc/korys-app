package akad2021.vakcina.users;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import akad2021.vakcina.PagingData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "user-servisas")
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	private final UserService userService;
	@Autowired
	@Qualifier("pagingData")
	private PagingData pagingData;
	
	
	public UserController(@Qualifier("userService")UserService userService) {
		this.userService = userService;
//		, @Qualifier("pagingData") PagingData pagingData
//		this.pagingData = pagingData;
	}

	/* Apdoros užklausas: GET /api/users */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get users",notes="Returns registered users")
	public List<User> getUsers() {
		pagingData.setLimit(10);
		return userService.getUsers()
				.stream()
				.map(user -> new User(user.getId(),user.getFirstName(),user.getLastName()))
				.collect(Collectors.toList()); 
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value="Save user",notes="")
	public void createUser( @RequestBody User user) {
		userService.setUser(new UserFromService(
				user.getId(),
				user.getFirstName(),
				user.getLastName()
				));
	}
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value="Create user",notes="Creates user with data")
//	public void createUser(@ApiParam(value="User Data",required=true)
//	@RequestBody final User user){
//		userService.createUser(user);
//	}
//	
//	public void deleteUser(String userName) {
//		userService.deleteUser(userName);
//	}
}