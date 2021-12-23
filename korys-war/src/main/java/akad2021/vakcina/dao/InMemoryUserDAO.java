package akad2021.vakcina.dao;
//package it.akademija.dao;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import it.akademija.PagingData;
//import it.akademija.users.User;
//
//public class InMemoryUserDAO implements UserDao {
//	private final List<User> users = new CopyOnWriteArrayList<>();
//
//	@Override
//	public void deleteUser(String username) {
//		for (User user : users) {
//			if (username.equals(user.getFirstName())) {
//				users.remove(user);
//				break;
//			}
//		}
//	}
//
//	@Override
//	public List<User> getUsers() {
//		return Collections.unmodifiableList(users);
//	}
//
//	@Override
//	public void createUser(User user) {
//		users.add(user);
//		
//	}
//
////	@Override
////	public void setPagingData(PagingData pagingData) {
////		// TODO Auto-generated method stub
////		
////	}
//}
