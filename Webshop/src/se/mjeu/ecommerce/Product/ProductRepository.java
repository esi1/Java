package se.mjeu.ecommerce.Product;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;
import se.mjeu.ecommerce.ProductCategory.ProductCategoryRepository;

public interface ProductRepository {
	public void addProduct(Product product) throws StorageException;
	public void deleteProduct(int id, OrderLineRepository orderLineRepository,
			ProductCategoryRepository productCategoryRepository) throws StorageException;
	 public Product updateProduct(Product product) throws StorageException;
	public Product getProduct(int id) throws StorageException;
	public String getAllProducts() throws StorageException;
}