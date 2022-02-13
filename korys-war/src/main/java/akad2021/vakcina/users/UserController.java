package akad2021.vakcina.users;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import akad2021.vakcina.PagingData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@Api(tags = "user-servisas")
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	private UserService userService;
//	@Autowired
//	@Qualifier("pagingData")
//	private PagingData pagingData;
	


	/* Apdoros užklausas: GET /api/users */
//	@RequestMapping(method = RequestMethod.GET)
//	@ApiOperation(value="Get users",notes="Returns registered users")
//	public List<User> getUsers() {
//		pagingData.setLimit(10);
//		return userService.getUsers()
//				.stream()
//				.map(user -> new User(user.getId(),user.getFirstName(),user.getLastName()))
//				.collect(Collectors.toList()); 
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT)
//	@ApiOperation(value="Save user",notes="")
//	public void createUser( @RequestBody UserFromService user) {
//		userService.setUser(user);
//	}
	/**
	 *
	 * Login. 
	 * @param userInfo
	 */
	
	@PostMapping(path = "/login")
	@ApiOperation(value = "Login user", notes = "Checks if password correct")
	public boolean loginUser(@Valid @RequestBody UserDTO userInfo) {

		User user = userService.findByUsername(userInfo.getUsername());
		if (user != null && user.getPassword().equals(userInfo.getPassword())) {

			return true;

		} else {
			return false;

		}
	}
	
	
	/**
	 *
	 * Create new user. 
	 * @param userInfo
	 */
	
	@PostMapping(path = "/createuser")
	@ApiOperation(value = "Create user", notes = "Creates user with data")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userInfo) {

		if (userService.findByUsername(userInfo.getUsername()) != null) {

			return new ResponseEntity<>("Toks naudotojas jau egzistuoja!", HttpStatus.BAD_REQUEST);

		} else {

			userService.createUser(userInfo);

			return new ResponseEntity<>("Naudotojas sukurtas sėkmingai!", HttpStatus.CREATED);
		}
	}

	/**
	 *
	 * Deletes user with specified username. Method only accessible to ADMIN users
	 *
	 * @param username
	 */
	@DeleteMapping(path = "/admin/delete/{username}")
	@ApiOperation(value = "Delete user", notes = "Deletes user by username")
	public ResponseEntity<String> deleteUser(
			@ApiParam(value = "Username", required = true) @PathVariable final String username) {

//		long id = userService.findByUsername(username).getUserId();

		if (userService.findByUsername(username) != null) {

			userService.deleteUser(username);

			return new ResponseEntity<>("Naudotojas ištrintas sėkmingai", HttpStatus.OK);
		}

		return new ResponseEntity<>("Naudotojas tokiu vardu nerastas", HttpStatus.NOT_FOUND);
	}

//	/**
//	 * Returns a list of users. Method only accessible to ADMIN users
//	 *
//	 * @return list of users
//	 */
//	@Secured({ "ROLE_ADMIN" })
//	@GetMapping(path = "/admin/allusers")
//	@ApiOperation(value = "Show all users", notes = "Showing all users")
//	public Page<UserInfo> getAllUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
//
//		Sort.Order order = new Sort.Order(Sort.Direction.DESC, "userId");
//
//		Pageable pageable = PageRequest.of(page, size, Sort.by(order));
//
//		return userService.getAllUsers(pageable);
//	}

//	/**
//	 * Get detail for logged in user
//	 *
//	 * @return user details
//	 */
//	@Secured({ "ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER" })
//	@GetMapping(path = "/user")
//	@ApiOperation(value = "Get details for logged in user")
//	public UserInfo getOneUser() {
//
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		if (userService.findByUsername(username) != null) {
//
//			LOG.info("** Usercontroller: ieškomas naudotojas vardu [{}] **", username);
//
//			return userService.getUserDetails(username);
//
//		}
//		return new UserInfo();
//	}

//	/**
//	 *
//	 * Restores password to initial value for the user with specified username.
//	 * Method only accessible to ADMIN users
//	 *
//	 * @param username
//	 */
//	@Secured({ "ROLE_ADMIN" })
//	@PutMapping(path = "/admin/password/{username}")
//	@ApiOperation(value = "Restore user password", notes = "Restore user password to initial value")
//	public ResponseEntity<String> restorePassword(
//			@ApiParam(value = "Username", required = true) @PathVariable final String username) {
//
//		if (userService.findByUsername(username) != null) {
//
//			userService.restorePassword(username);
//
//			LOG.info("** Usercontroller: keiciamas slaptazodis naudotojui vardu [{}] **", username);
//
//			journalService.newJournalEntry(OperationType.USER_DATA_CHANGED,
//					userService.findByUsername(username).getUserId(), ObjectType.USER,
//					"Atstatytas naudotojo slaptažodis");
//
//			return new ResponseEntity<>("Slaptažodis atkurtas sėkmingai", HttpStatus.OK);
//		}
//
//		return new ResponseEntity<>("Naudotojas tokiu vardu nerastas", HttpStatus.NOT_FOUND);
//	}

//	/**
//	 *
//	 * Update user data
//	 *
//	 * @param userData
//	 * @return message
//	 */
//////	@Secured({ "ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER" })
////	@PutMapping(path = "/update")
////	@ApiOperation(value = "Update logged in user details")
////	public ResponseEntity<String> updateUserData(@Valid @RequestBody UserDTO userData) {
////
////		String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
////
////		userService.updateUserData(userData, currentUserName);
////
////		LOG.info("** Usercontroller: keiciami duomenys naudotojui vardu [{}] **", currentUserName);
////
////		journalService.newJournalEntry(OperationType.USER_DATA_CHANGED,
////				userService.findByUsername(currentUserName).getUserId(), ObjectType.USER,
////				"Pakeisti naudotojo duomenys");
////
////		return new ResponseEntity<>("Duomenys pakeisti sėkmingai", HttpStatus.OK);
////
////	}

	/**
	 * Change user password for logged in user
	 *
	 * @param oldPassword
	 * @param newPassword
	 * @return message
	 */
//	@Secured({ "ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER" })
	@PutMapping(path = "/updatepassword/{currentUsername}/{oldPassword}/{newPassword}")
	@ApiOperation(value = "Update logged in user password")
	public ResponseEntity<String> updateUserPassword(@PathVariable(value = "currentUsername") final String currentUsername,
			@PathVariable(value = "oldPassword") final String oldPassword,
			@PathVariable(value = "newPassword") final String newPassword) {

//		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

		
		if (userService.changePassword(currentUsername, oldPassword, newPassword)) {

			return new ResponseEntity<>("Slaptažodis pakeistas sėkmingai", HttpStatus.OK);

		} else {


			return new ResponseEntity<>("Neteisingas senas slaptažodis", HttpStatus.BAD_REQUEST);

		}
	}

//	/**
//	 * Get GDPR user data zip archive
//	 *
//	 * @param response
//	 * @throws IOException
//	 */
//	@Secured({ "ROLE_USER" })
//	@GetMapping(path = "/user/zip")
//	@ApiOperation(value = "Get GDPR user data zip archive")
//	public void zipUserInformation(HttpServletResponse response) throws IOException {
//
//		String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		User user = userService.findByUsername(currentUsername);
//
//		String userJsonString = jsonExporter.export(user);
//
//		byte[] jsonBytes = userJsonString.getBytes("UTF8");
//
//		response.setContentType("application/zip");
//		response.setStatus(HttpServletResponse.SC_OK);
//		response.setHeader("Content-Disposition", "attachment; filename=naudotojas.zip");
//
//		ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
//
//		InputStream inputStream = new ByteArrayInputStream(jsonBytes);
//
//		zipOutputStream.putNextEntry(new ZipEntry("naudotojas.json"));
//
//		IOUtils.copy(inputStream, zipOutputStream);
//
//		inputStream.close();
//
//		zipOutputStream.closeEntry();
//
//		zipOutputStream.close();
//	}
//
//	/**
//	 * "Forget me" functionality which deletes all user related entries from
//	 * database
//	 *
//	 */
//	@Secured({ "ROLE_USER" })
//	@DeleteMapping(path = "/user/deletemydata")
//	@ApiOperation(value = "Forget me - delete all user data")
//	public void deleteMyUserData() {
//
//		userService.deleteMyUserData();
//	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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