package se.mjeu.ecommerce.OrderLine;

public class OrderLine {
	private final int orderLineId;
	private final int userId;
	private final int orderId;
	private final int productId;
	private int quantity;
	
	public OrderLine(int orderLineId, int userId, int orderId, int productId, int quantity) {
		this.orderLineId = orderLineId;
		this.userId = userId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public int getOrderLineId() {
		return orderLineId;
	}

	public int getUserId() {
		return userId;
	}

	public int getOrderId() {
		return orderId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; };
		
		OrderLine orderLineTemp = null;
		
		if(obj instanceof OrderLine) {
			orderLineTemp = (OrderLine) obj;
		}
		
		return ((this.orderLineId == orderLineTemp.orderLineId && this.userId != orderLineTemp.userId) ||
				(this.orderLineId == orderLineTemp.orderLineId && this.productId == orderLineTemp.productId) ||
				(this.orderLineId != orderLineTemp.orderLineId && this.orderId == orderLineTemp.orderId) ||
				(this.orderLineId == orderLineTemp.orderLineId && this.orderId != orderLineTemp.orderId));
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		
		result += 37 * this.userId;
		result += 37 * this.orderId;
		result += 37 * this.orderLineId;
		result += 37 * this.productId;
		
		return result;
	}
	
	@Override
	public String toString() {
		String orderLineInfo = "";
		
		orderLineInfo += "OrderLineId: " + this.orderLineId + "\n";
		orderLineInfo += "UserId: " + this.userId + "\n";
		orderLineInfo += "OrderId: " + this.orderId + "\n";
		orderLineInfo += "ProductId: " + this.productId + "\n";
		orderLineInfo += "Quantity: " + this.quantity + "\n";
		
		return orderLineInfo;
	}
}