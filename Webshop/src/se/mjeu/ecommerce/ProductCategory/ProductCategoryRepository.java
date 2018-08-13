package se.mjeu.ecommerce.ProductCategory;

import java.util.List;

import se.mjeu.ecommerce.Category.CategoryRepository;
import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Product.ProductRepository;

public interface ProductCategoryRepository {
	public void addProductCategory(ProductCategory productCategory,
			CategoryRepository categoryRepository, ProductRepository productRepository) throws StorageException;
	public void deleteProductCategory(int categoryId) throws StorageException;
	 public ProductCategory updateProductCategory(ProductCategory productCategory) throws StorageException;
	public List<ProductCategory> getProductCategory(int categoryId) throws StorageException;
	public List<ProductCategory> listAllProductCategories() throws StorageException;
	public String getAllProductCategories() throws StorageException;
}