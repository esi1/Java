package se.mjeu.ecommerce.Product;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLine;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;
import se.mjeu.ecommerce.ProductCategory.ProductCategory;
import se.mjeu.ecommerce.ProductCategory.ProductCategoryRepository;

public final class InMemoryProductRepository implements ProductRepository {
	private Map<Integer, Product> products;
	
	public InMemoryProductRepository() {
		products = new HashMap<>();
	}
	
	@Override
	public void addProduct(Product product) throws StorageException {
		if(products.containsValue(product)) {
			throw new StorageException("You already have product with id: " + product.getProductId() + " in the repository");
		} else {
			products.put(product.getProductId(), product);
		}
	}
	
	@Override
	public Product getProduct(int id) throws StorageException {
		if(products.containsKey(id)) {
			return products.get(id);
		} else {
			throw new StorageException("You don't have product with id: " + id + " in the repository");
		}
	}

	@Override
	public void deleteProduct(int id, OrderLineRepository orderLineRepository,
	ProductCategoryRepository productCategoryRepository) throws StorageException {
		if(products.containsKey(id)) {
			Iterator<OrderLine> itr1 = orderLineRepository.listAllOrderLines().iterator();
			
			while(itr1.hasNext()) {
				if(itr1.next().getProductId() == id) {
					itr1.remove();
				}
			}
			
			Iterator<ProductCategory> itr2 = productCategoryRepository.listAllProductCategories().iterator();
			
			while(itr2.hasNext()) {
				if(itr2.next().getProductId() == id) {
					itr2.remove();
				}
			}
			
			products.remove(id);
		} else {
			throw new StorageException("You can't delete product with id: " + id + " in the repository");
		}
	}

	@Override
	public String getAllProducts() throws StorageException {
		String productInfo = "";
		
		if(products.size() == 0) {
			throw new StorageException("You don't have any products to show");
		} 
		
		for(Product p : products.values()) {
			productInfo += "------------------------------------------\n";
			productInfo += p;
			productInfo += "------------------------------------------\n\n";
		}
		
		return productInfo;
	}
}