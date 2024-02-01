package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.Client;

import entities.Enums.OrderStatus;

public class Order {

	public static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	private Date moment = new Date();
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<OrderItem>();
	private Client client;
	
	public Order(){
	}

	public Order(Date moment, OrderStatus status, List<OrderItem> item) {
		this.moment = moment;
		this.status = status;
		items = item;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem Item) {
		items.add(Item);
	}
	
	public void removeItem(OrderItem Item) {
		items.remove(Item);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem it : items) {
			 sum += it.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment)+ "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		for(OrderItem item : items){
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}

