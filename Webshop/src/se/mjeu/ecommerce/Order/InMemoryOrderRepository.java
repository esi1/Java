package se.mjeu.ecommerce.Order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLine;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public class InMemoryOrderRepository implements OrderRepository {
	private Map<Integer, Order> orders;
	
	public InMemoryOrderRepository() {
		orders = new HashMap<>();
	}

	@Override
	public void addOrder(Order order) throws StorageException {
		if(orders.containsValue(order)) {
			throw new StorageException("You already have order with id: " + order.getOrderId() + " in the repository");
		} else {
			orders.put(order.getOrderId(), order);
		}
	}

	@Override
	public void deleteOrder(int id, OrderLineRepository orderLineRepository) throws StorageException {
		if(orders.containsKey(id)) {
			Iterator<OrderLine> itr = orderLineRepository.listAllOrderLines().iterator();
			
			while(itr.hasNext()) {
				if(itr.next().getOrderId() == id) {
					itr.remove();
				}
			}
			
			orders.remove(id);
		} else {
			throw new StorageException("You can't delete order with id: " + id + " in the repository");
		}
	}

	@Override
	public Order getOrder(int id) throws StorageException {
		if(orders.containsKey(id)) {
			return orders.get(id);
		} else {
			throw new StorageException("You don't have order with id: " + id + " in the repository");
		}
	}

	@Override
	public String getAllOrders() throws StorageException {
		String orderInfo = "";
		
		if(orders.size() == 0) {
			throw new StorageException("You don't have any orders to show");
		} 
		
		for(Order o : orders.values()) {
			orderInfo += "------------------------------------------\n";
			orderInfo += o;
			orderInfo += "orderId: " + o.getOrderId() + "\n";
			orderInfo += "date: " + o.getDate() + "\n";
			orderInfo += "paid: " + o.isPaid() + "\n";
			orderInfo += "delivered: " + o.isDelivered() + "\n";
			orderInfo += "------------------------------------------\n\n";
		}
		
		return orderInfo;
	}
}