package se.mjeu.ecommerce.ProductCategory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import se.mjeu.ecommerce.Category.CategoryRepository;
import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Product.ProductRepository;

public class InMemoryProductCategoryRepository implements ProductCategoryRepository {
	private List<ProductCategory> productCategories;
	
	public InMemoryProductCategoryRepository() {
		productCategories = new ArrayList<>();
	}
	
	@Override
	public void addProductCategory(ProductCategory productCategory,
	CategoryRepository categoryRepository, ProductRepository productRepository) throws StorageException {
		if(productCategories.contains(productCategory)) {
			throw new StorageException("The product id: " + productCategory.getProductId() + " is already used in the repository");
		}
		else if(categoryRepository.getCategory(productCategory.getCategoryId()) == null) {}
		else if(productRepository.getProduct(productCategory.getProductId()) == null) {}
		else {
			productCategories.add(productCategory);
		}
	}

	@Override
	public void deleteProductCategory(int categoryId) throws StorageException {
		boolean notExistCheck = true;
		Iterator<ProductCategory> itr = productCategories.iterator();
		
		while(itr.hasNext()) {
			if(itr.next().getCategoryId() == categoryId) {
				notExistCheck = false;
				itr.remove();
			}
		}
		
		if(notExistCheck) {
			throw new StorageException("The category id: " + categoryId + " doesn't exist in the productCategory repository");
		}
	}

	@Override
	public List<ProductCategory> getProductCategory(int categoryId) throws StorageException {
		boolean notExistCheck = true;
		List<ProductCategory> tempProductCategories = new ArrayList<>();
		
		for(ProductCategory pc : productCategories) {
			if(pc.getCategoryId() == categoryId) {
				notExistCheck = false;
				tempProductCategories.add(pc);
			}
		}
		
		if(notExistCheck) {
			throw new StorageException("The category id: " + categoryId + " doesn't exist in the productCategory repository");
		}
		
		return tempProductCategories;
	}
	
	@Override
	public List<ProductCategory> listAllProductCategories() throws StorageException {
		return productCategories;
	}
	
	@Override
	public String getAllProductCategories() throws StorageException {
		Set<Integer> tempOrderedProductCategoryIds = new TreeSet<>();
		String productCategoryInfo = "";
		
		if(productCategories.size() == 0) {
			throw new StorageException("You don't have any productCategories to show");
		} 
		
		for(ProductCategory pc : productCategories) {
			tempOrderedProductCategoryIds.add(pc.getCategoryId());
		}
		
		for(int tpc : tempOrderedProductCategoryIds) {
			boolean firstTimeCheck = true;
			
			productCategoryInfo += "--------------------------------------\n";
			
			for(ProductCategory pc : this.getProductCategory(tpc)) {
				if(firstTimeCheck) {
					firstTimeCheck = false;
					
					productCategoryInfo += "CategoryId: " + pc.getCategoryId() + "\n\n";
					productCategoryInfo += "**************************\n\n";
				}
				
				productCategoryInfo += "ProductId: " + pc.getProductId() + "\n";
			}
			
			productCategoryInfo += "--------------------------------------\n\n";
		}
		
		return productCategoryInfo;
	}
}