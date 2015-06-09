
public class Product {
	private String description;
	private double price;
		
	public Product(String description , double price) {
		this.description = description;
		this.price = price;
	}
	public double getPrix() {
		return this.price;
	}
	public String getDescription() {
		return this.description;
	}
}

