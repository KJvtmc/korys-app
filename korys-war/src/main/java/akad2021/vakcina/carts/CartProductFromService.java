package akad2021.vakcina.carts;

public class CartProductFromService {
	public String title;
	public double price;
	public int quantity;
	
	public CartProductFromService() {
	}

	public CartProductFromService(String title, double price, int quantity) {
		super();
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
