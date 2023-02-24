package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momment = new Date();
	private Client client;
	private OrderStatus status;
	List<OrderItem> orderItems = new ArrayList<>();
	
	public Order() {}

	public Order(Client client, String status) {
		this.client = client;
		this.status = OrderStatus.valueOf(status);
	}

	public Date getMomment() {
		return momment;
	}

	public void setMomment(Date momment) {
		this.momment = momment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	public Double total() {
		Double total = 0d;
		for (OrderItem orderItem : orderItems) {
			total += orderItem.subTotal();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + df.format(momment) + "\n");
		sb.append("Order Status: " + status + "\n");
		sb.append("Client: " + client.getName() + " - " + client.getEmail());
		sb.append("\nOrder Items \n");
		for (OrderItem orderItem : orderItems) {
			sb.append(orderItem.getProduct().getName() 
					+ ", "
					+ "$" + orderItem.getPrice() 
					+ ", "
					+ "Quantity: " + orderItem.getQuantity()
					+ ", "
					+ "Subtotal: $" + orderItem.subTotal() + "\n");
		}
		sb.append("Total price: $" + total());
		
		return sb.toString();
	}
}
