package akad2021.vakcina.carts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import akad2021.vakcina.PagingData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(tags = "user-servisas")
@RequestMapping(value = "/cart/list")
public class CartControler {
	@Autowired
	private final CartService cartService;
	@Autowired
	@Qualifier("pagingData")
	private PagingData pagingData;

	@Autowired
	public CartControler(@Qualifier("cartService") CartService cartService) {
		super();
		this.cartService = cartService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value="Get products from cart",notes="Returns products from cart")
    public List<CartProduct> getProducts() {
		pagingData.setLimit(10);
		return cartService.getProducts()
				.stream()
				.map(p->new CartProduct(p.getTitle(), p.getPrice(), p.getQuantity()))
				.collect(Collectors.toList()); 
    }

}
