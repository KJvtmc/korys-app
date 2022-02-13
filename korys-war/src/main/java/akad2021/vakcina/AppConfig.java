package akad2021.vakcina;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import akad2021.vakcina.carts.CartProduct;
import akad2021.vakcina.centras.Centras;
import akad2021.vakcina.centras.Kabina;
import akad2021.vakcina.centras.Vakcina;
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
	
	@Bean(name="vakcina")
	public Vakcina getVakcina() {
		return new Vakcina();
	}
	
	@Bean(name="vakcinos")
	public List<Vakcina> getVakcinos() {
		return new ArrayList<Vakcina>();
	}
	
	@Bean(name="kabina")
	public Kabina getKabina() {
		return new Kabina();
	}
	
	@Bean(name="kabinos")
	public List<Kabina>getKabinos() {
		return new ArrayList<Kabina>();
	}
	
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
	
	//Boolean
	
	@Bean(name="statusas")
	public Boolean getStatusas() {
		return false;
	}
	
	//Strings
	
	@Bean(name="pavadinimas")
	public String getPavadinimas() {
		return "DefaultTitle";
	}
	
	@Bean(name="vieta")
	public String getVieta() {
		return "DefaultAddress";
	}
	
	@Bean(name="vakcinosPavadinimas")
	public String getVakcinosPavadinimas() {
		return "DefaultVaccineTitle";
	}
	
	@Bean(name="gamintojas")
	public String getGamintojas() {
		return "DefaultVaccineSupplier";
	}
	
	@Bean(name="itemTitle")
	public String getItemTitle() {
		return "DefaultTitle";
	}
	
	@Bean(name="imgNuoroda")
	public String getPriceString() {
		return "hospital.jpg";
	}
	
	@Bean(name="aprasymas")
	public String getQuantityString() {
		return "Vakcinacijos centro aprasymas bus patikslintas netrukus";
	}
	
	@Bean(name="itemFirstName")
	public String getFirstName() {
		return "DefaultFirstName";
	}
	
	@Bean(name="itemLastName")
	public String getLastNameString() {
		return "DefaultLastName";
	}

	//Numbers
	
	@Bean(name="partija")
	public Long getPartija() {
		return (long) 0;
	}
	

	@Bean(name="vakcinosKiekis")
	public int getVakcinosKiekis() {
		return 0;
	}
	
	@Bean(name="centroNr")
	public Long getCentroNr() {
		return (long) 100000001;
	}
	
	@Bean(name="kabinosNr")
	public Long getKabinosNr() {
		return (long) 200000001;
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
	
	
}