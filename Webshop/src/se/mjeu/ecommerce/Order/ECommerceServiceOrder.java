package se.mjeu.ecommerce.Order;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public final class ECommerceServiceOrder implements OrderRepository {
	private OrderRepository orderRepository;

	public ECommerceServiceOrder(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void addOrder(Order order) throws StorageException {
		orderRepository.addOrder(order);
	}

	@Override
	public void deleteOrder(int id, OrderLineRepository orderLineRepository) throws StorageException {
		orderRepository.deleteOrder(id, orderLineRepository);
	}

	@Override
	public Order getOrder(int id) throws StorageException {
		return orderRepository.getOrder(id);
	}

	@Override
	public String getAllOrders() throws StorageException {
		return orderRepository.getAllOrders();
	}
}
