package akad2021.vakcina;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import akad2021.vakcina.carts.CartProduct;
import akad2021.vakcina.centras.Centras;
import akad2021.vakcina.users.User;

@ImportResource({"classpath*:application-context.xml"})


@Configuration
public class AppConfig {
	
	//Services
	
//	@Bean(name="userService")
//	public UserService getUserService() {
//		return new UserService();
//	}
	
//	@Bean(name="pagingData")
//	public PagingData getPagingData() {
//		return new PagingData();
//	}
//	
	//Objects
	
	@Bean(name="centras")
	public Centras getProduct() {
		return new Centras();
	}

	@Bean(name="cartProduct")
	public CartProduct getCartProduct() {
		return new CartProduct();
	}
	
//	@Bean(name="user")
//	public User getUser() {
//		return new User();
//	}
	
	//DAO
	
//	@Bean(name="inMemoryProductDAO")
//	public InMemoryProductDAO getProductDao() {
//		return new InMemoryProductDAO();
//	}
//	@Bean(name="inMemoryCartProductDAO")
//	public InMemoryCartProductDAO getCartProductDao() {
//		return new InMemoryCartProductDAO();
//	}
	
//	@Bean(name="userDaoInMemory")
//	public InMemoryUserDAO getUserDao() {
//		return new InMemoryUserDAO();
//	}
//	
//	@Bean(name="dBUserDAO")
//	public DBUserDAO getDBUserDao() {
//		return new DBUserDAO();
//	}
	
	//Strings
	
	@Bean(name="pavadinimas")
	public String getPavadinimas() {
		return "DefaultTitle";
	}
	
	@Bean(name="itemTitle")
	public String getItemTitle() {
		return "DefaultTitle";
	}
	
	@Bean(name="imgNuoroda")
	public String getPriceString() {
		return "DefaultLink";
	}
	
	@Bean(name="aprasymas")
	public String getQuantityString() {
		return "Vakcinacijos centro aprasymas bus patikslintas netrukus";
	}
	

	@Bean(name="itemPriceD")
	public double getPriceDouble() {
		return 0;
	}
	
	@Bean(name="itemQuantityInt")
	public int getQuantityInt() {
		return 0;
	}
	
	@Bean(name="id")
	public Long getUserId() {
		return (long) 400000000;
	}
	
	@Bean(name="itemFirstName")
	public String getFirstName() {
		return "DefaultFirstName";
	}
	
	@Bean(name="itemLastName")
	public String getLastNameString() {
		return "DefaultLastName";
	}
}