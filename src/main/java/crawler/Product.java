package crawler;

public class Product {

	String name;
	String price;
			

	public Product(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
