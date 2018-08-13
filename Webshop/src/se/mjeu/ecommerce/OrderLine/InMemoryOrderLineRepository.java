package se.mjeu.ecommerce.OrderLine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Order.OrderRepository;
import se.mjeu.ecommerce.Product.ProductRepository;
import se.mjeu.ecommerce.User.UserRepository;

public class InMemoryOrderLineRepository implements OrderLineRepository {
	private List<OrderLine> orderLines;
	
	public InMemoryOrderLineRepository() {
		orderLines = new ArrayList<>();
	}
	
	@Override
	public void addOrderLine(OrderLine orderLine, UserRepository userRepository,
	OrderRepository orderRepository, ProductRepository productRepository) throws StorageException {
		if(orderLines.contains(orderLine)) {
			throw new StorageException("This orderline combination is already used in the repository");
		} else if(orderLine.getQuantity() > productRepository.getProduct(orderLine.getProductId()).getQuantity()) {
			throw new StorageException("You haven't got " + orderLine.getQuantity() + " of product with id: " + orderLine.getProductId() + " in the repository");
		}
		else if(userRepository.getUser(orderLine.getUserId()) == null) {}
		else if(orderRepository.getOrder(orderLine.getOrderId()) == null) {}
		else if(productRepository.getProduct(orderLine.getProductId()) == null) {}
		else {
			int tempQuantity = (productRepository.getProduct(orderLine.getProductId()).getQuantity()) - orderLine.getQuantity();
			productRepository.getProduct(orderLine.getProductId()).setQuantity(tempQuantity);
			orderLines.add(orderLine);
		}
	}

	@Override
	public void deleteOrderLine(int id) throws StorageException {
		boolean notExistCheck = true;
		Iterator<OrderLine> itr = orderLines.iterator();
		
		while(itr.hasNext()) {
			if(itr.next().getOrderLineId() == id) {
				notExistCheck = false;
				itr.remove();
			}
		}
		
		if(notExistCheck) {
			throw new StorageException("The orderline id: " + id + " doesn't exist in the repository");
		}
	}

	@Override
	public List<OrderLine> getOrderLine(int id) throws StorageException {
		boolean notExistCheck = true;
		List<OrderLine> tempOrderLines = new ArrayList<>();
		
		for(OrderLine ol : orderLines) {
			if(ol.getOrderLineId() == id) {
				notExistCheck = false;
				tempOrderLines.add(ol);
			}
		}
		
		if(notExistCheck) {
			throw new StorageException("The orderline id: " + id + " doesn't exist in the repository");
		}
		
		return tempOrderLines;
	}
	
	@Override
	public List<OrderLine> listAllOrderLines() throws StorageException {
		return orderLines;
	}
	
	@Override
	public String getAllOrderLines(ProductRepository productRepository) throws StorageException {
		Set<Integer> tempOrderedOrderLineIds = new TreeSet<>();
		String orderLineInfo = "";
		double sum;
		
		if(orderLines.size() == 0) {
			throw new StorageException("You don't have any orderlines to show");
		} 
		
		for(OrderLine ol : orderLines) {
			tempOrderedOrderLineIds.add(ol.getOrderLineId());
		}
		
		for(int tol : tempOrderedOrderLineIds) {
			boolean firstTimeCheck = true;
			sum = 0.0;
			
			orderLineInfo += "--------------------------------------\n";
			
			for(OrderLine ol : this.getOrderLine(tol)) {
				if(firstTimeCheck) {
					firstTimeCheck = false;
					
					orderLineInfo += "OrderLineId: " + ol.getOrderLineId() + "\n";
					orderLineInfo += "UserId: " + ol.getUserId() + "\n";
					orderLineInfo += "OrderId: " + ol.getOrderId() + "\n\n";
					orderLineInfo += "**************************\n\n";
				} else {
					orderLineInfo += "\n";
				}
				
				orderLineInfo += "ProductId: " + ol.getProductId() + "\n";
				orderLineInfo += "Price: " + productRepository.getProduct(ol.getProductId()).getPrice() + "\n";
				orderLineInfo += "Quantity: " + ol.getQuantity() + "\n";
				
				sum += productRepository.getProduct(ol.getProductId()).getPrice() * ol.getQuantity();
			}
			
			orderLineInfo += "\n**************************\n\n";
			orderLineInfo += "Total price: " + sum + "\n";
			orderLineInfo += "--------------------------------------\n\n";
		}
		
		return orderLineInfo;
	}
}