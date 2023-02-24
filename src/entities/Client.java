package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String name;
	private String email;
	List<Order> orders = new ArrayList<>();
	
	public Client() {}
	
	public Client(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	
}
