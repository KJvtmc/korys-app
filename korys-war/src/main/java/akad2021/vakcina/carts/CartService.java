package akad2021.vakcina.carts;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import akad2021.vakcina.dao.CartProductDao;

@Service
public class CartService {
	@Autowired
	private CartProductDao cartProductDao;
	

	@Transactional(readOnly = true)
	public List<CartProductFromService> getProducts() {
		return cartProductDao.findAll().stream()
				.map(p -> new CartProductFromService(p.getTitle(),p.getPrice(),p.getQuantity()))
				.collect(Collectors.toList()); 
	}
	@Transactional
	public void setProduct(CartProductFromService cartProductFromService) {
		var product = new CartProduct(cartProductFromService.getTitle(),cartProductFromService.getPrice(),cartProductFromService.getQuantity());
		cartProductDao.save(product);
	}


	public CartProductDao getCartProductDao() {
		return cartProductDao;
	}


	public void setCartProductDao(CartProductDao cartProductDao) {
		this.cartProductDao = cartProductDao;
	}
}
