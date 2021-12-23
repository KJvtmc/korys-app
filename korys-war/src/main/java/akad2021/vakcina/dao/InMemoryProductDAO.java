package akad2021.vakcina.dao;
//package it.akademija.dao;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import it.akademija.products.Product;
//
//public class InMemoryProductDAO implements CentrasDao {
//	private final List<Centras> products = new CopyOnWriteArrayList<>();
//
//	@Override
//	public void deleteProduct(String title) {
//		for (Centras product : products ) {
//			if (title.equals(product.getTitle())) {
//				products.remove(product);
//				break;
//			}
//		}
//	}
//
//	@Override
//	public List<Centras> getProducts() {
//		return Collections.unmodifiableList(products);
//	}
//
//	@Override
////	@Autowired
//	public void createProduct(Centras product) {
//		products.add(product);
//		
//	}
//}
