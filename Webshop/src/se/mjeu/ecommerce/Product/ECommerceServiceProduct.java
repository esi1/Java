package se.mjeu.ecommerce.Product;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;
import se.mjeu.ecommerce.ProductCategory.ProductCategoryRepository;

public final class ECommerceServiceProduct implements ProductRepository {
	private ProductRepository productRepository;

	public ECommerceServiceProduct(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(Product product) throws StorageException {
		productRepository.addProduct(product);
	}
	
	@Override
	public void deleteProduct(int id, OrderLineRepository orderLineRepository,
	ProductCategoryRepository productCategoryRepository) throws StorageException {
		productRepository.deleteProduct(id, orderLineRepository, productCategoryRepository);
	}

	@Override
	public Product getProduct(int id) throws StorageException {
		return productRepository.getProduct(id);
	}
	
	@Override
	public String getAllProducts() throws StorageException {
		return productRepository.getAllProducts();
	}
}
