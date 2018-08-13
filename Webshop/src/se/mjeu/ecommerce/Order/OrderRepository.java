package se.mjeu.ecommerce.Order;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public interface OrderRepository {
	public void addOrder(Order order) throws StorageException;
	public void deleteOrder(int id, OrderLineRepository orderLineRepository) throws StorageException;
	public Order updateOrder(Order order) throws StorageException;
	public Order getOrder(int id) throws StorageException;
	public String getAllOrders() throws StorageException;
}