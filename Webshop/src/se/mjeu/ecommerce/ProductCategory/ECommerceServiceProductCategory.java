package se.mjeu.ecommerce.ProductCategory;

import java.util.List;

import se.mjeu.ecommerce.Category.CategoryRepository;
import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Product.ProductRepository;

public final class ECommerceServiceProductCategory implements ProductCategoryRepository {
	private ProductCategoryRepository productCategoryRepository;
	
	public ECommerceServiceProductCategory(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}
	
	@Override
	public void addProductCategory(ProductCategory productCategory, CategoryRepository categoryRepository,
	ProductRepository productRepository) throws StorageException {
		productCategoryRepository.addProductCategory(productCategory, categoryRepository, productRepository);
	}

	@Override
	public void deleteProductCategory(int id) throws StorageException {
		productCategoryRepository.deleteProductCategory(id);
	}

	@Override
	public List<ProductCategory> getProductCategory(int categoryId) throws StorageException {
		return productCategoryRepository.getProductCategory(categoryId);
	}
	
	@Override
	public List<ProductCategory> listAllProductCategories() throws StorageException {
		return productCategoryRepository.listAllProductCategories();
	}
	
	@Override
	public String getAllProductCategories() throws StorageException {
		return productCategoryRepository.getAllProductCategories();
	}
}
