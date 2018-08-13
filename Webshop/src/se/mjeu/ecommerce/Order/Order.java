package se.mjeu.ecommerce.Order;

import se.mjeu.ecommerce.Data.StorageException;

public class Order {
	private final int orderId;
	private String date;
	private boolean paid;
	private boolean delivered;
	
	public Order(int orderId) {
		this.orderId = orderId;
		this.date = "No date set yet";
		this.paid = false;
		this.delivered = false;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) throws StorageException {
		if(date == null) {
			throw new StorageException("You can't have null as date");
		} else if(date.isEmpty()) {
			throw new StorageException("You can't have an empty date");
		}
		else {
			this.date = date;
		}
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		
		Order orderTemp = null;
		
		if(obj instanceof Order) {
			orderTemp = (Order) obj;
		}
		return (this.orderId == orderTemp.orderId);
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * this.orderId;
		return result;
	}
	
	@Override
	public String toString() {
		String orderInfo = "";
		
		orderInfo += "orderId: " + this.orderId + "\n";
		orderInfo += "date: " + this.date + "\n";
		orderInfo += "paid: " + this.paid + "\n";
		orderInfo += "delivered: " + this.delivered + "\n";
		
		return orderInfo;
	}
}