package se.mjeu.ecommerce.OrderLine;

import java.util.List;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Order.OrderRepository;
import se.mjeu.ecommerce.Product.ProductRepository;
import se.mjeu.ecommerce.User.UserRepository;

public final class ECommerceServiceOrderLine implements OrderLineRepository {
	private OrderLineRepository orderLineRepository;

	public ECommerceServiceOrderLine (OrderLineRepository orderLineRepository) {
		this.orderLineRepository = orderLineRepository;
	}

	@Override
	public void addOrderLine(OrderLine orderLine, UserRepository userRepository,
	OrderRepository orderRepository, ProductRepository productRepository) throws StorageException {
		orderLineRepository.addOrderLine(orderLine, userRepository, orderRepository, productRepository);
	}

	@Override
	public void deleteOrderLine(int id) throws StorageException {
		orderLineRepository.deleteOrderLine(id);
	}

	@Override
	public List<OrderLine> getOrderLine(int id) throws StorageException {
		return orderLineRepository.getOrderLine(id);
	}

	@Override
	public List<OrderLine> listAllOrderLines() throws StorageException {
		return orderLineRepository.listAllOrderLines();
	}
	
	@Override
	public String getAllOrderLines(ProductRepository productRepository) throws StorageException {
		return orderLineRepository.getAllOrderLines(productRepository);
	}
}
