package application;


import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;


public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		Client cliente = new Client(name, email);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("How many items to this order? ");
		Integer quantity = sc.nextInt();
		Order order = new Order(cliente,status);
		for (int i = 1; i <= quantity; i++) {
			sc.nextLine();
			System.out.printf("Enter #%d item data: \n", i);
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			sc.nextLine();
			Integer productQuantity = sc.nextInt();

			order.addItem(new OrderItem(productQuantity, new Product(productName, productPrice)));
		}
		cliente.addOrder(order);
		
		System.out.printf("\nORDER SUMARY: \n");
		System.out.println(order);
		
		sc.close();
	}

}
