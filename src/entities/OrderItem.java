package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product product;
	
	

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		this.price = product.getPrice();
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void addQuantity(Integer quantity) {
		this.quantity += quantity;
	}
	
	public void removeQuantity(Integer quantity) {
		this.quantity -= quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return quantity * price;
	}
	
}
