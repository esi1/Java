package se.mjeu.ecommerce.OrderLine;

import java.util.List;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Order.OrderRepository;
import se.mjeu.ecommerce.Product.ProductRepository;
import se.mjeu.ecommerce.User.UserRepository;

public interface OrderLineRepository {
	public void addOrderLine(OrderLine orderLine, UserRepository userRepository,
			OrderRepository orderRepository, ProductRepository productRepository) throws StorageException;
	public void deleteOrderLine(int id) throws StorageException;
	public List<OrderLine> getOrderLine(int id) throws StorageException;
	public List<OrderLine> listAllOrderLines() throws StorageException;
	public String getAllOrderLines(ProductRepository productRepository) throws StorageException;
}