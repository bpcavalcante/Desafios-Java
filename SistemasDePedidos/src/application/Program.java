package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		
		System.out.print("Name:");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(sc.next());
		sc.nextLine();
		
		Client client = new Client(name,email,date);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		System.out.print("How many items to this order ?");
		int n = sc.nextInt();
		
		sc.nextLine();
		
		Product product = null;
		OrderItem orderItem = null;
		Order order = new Order(new Date(),OrderStatus.valueOf(status),client);
		
		for(int i = 0; i < n ; i++) {
			System.out.println("Enter #" + (i + 1)  + " item data: " );
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			sc.nextLine();
			
			product = new Product(productName,productPrice);
			orderItem = new OrderItem(quantityProduct,productPrice,product);			
			order.addItem(orderItem);
			
		}
		
		System.out.println("Order Sumary: ");
		System.out.println("Order Moment: " + sdf.format(order.getMoment()));//
		System.out.println("Order Status: " + order.getStatus());
		System.out.println("Client " + client.getName() + "(" + sdf.format(client.getBirthDate()) + ") - " + client.getEmail());
		System.out.println("Order Items :");
		
		for(int i = 0 ; i < n; i++) {
			System.out.println(order.getOrderItem().get(i).getProduct().getName() + " " + "$" + order.getOrderItem().get(i).getPrice() + " " 
				+ "Quantity: " + order.getOrderItem().get(i).getQuantity() + " " 
					+ "Subtotal : " + "$" + order.getOrderItem().get(i).subTotal());
		}
		
		System.out.println("Total price: " + "$" + order.total());		
		
	}

} 
