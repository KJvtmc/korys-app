package akad2021.vakcina.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import akad2021.vakcina.carts.CartProduct;

public interface CartProductDao extends JpaRepository<CartProduct, Long>{
	
	
}
