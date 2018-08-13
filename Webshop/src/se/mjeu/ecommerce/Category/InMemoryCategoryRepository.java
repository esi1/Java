package se.mjeu.ecommerce.Category;

import se.mjeu.ecommerce.Data.StorageException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCategoryRepository implements CategoryRepository {
	private Map<Integer, Category> categories;
	
	public InMemoryCategoryRepository() {
		categories = new HashMap<>();
	}

	@Override
	public void addCategory(Category category) throws StorageException {
		if(categories.containsValue(category)) {
			throw new StorageException("Either the id is already used, or category name is already used in the repository");
		} else {
			categories.put(category.getCategoryId(), category);
		}
	}

	@Override
	public void deleteCategory(int id) throws StorageException {
		if(categories.containsKey(id)) {
			categories.remove(id);
		} else {
			throw new StorageException("You can't delete category with id: " + id + " in the repository");
		}
	}

	@Override
	public Category getCategory(int id) throws StorageException {
		if(categories.containsKey(id)) {
			return categories.get(id);
		} else {
			throw new StorageException("You don't have category with id: " + id + " in the repository");
		}
	}

	@Override
	public String getAllCategories() throws StorageException {
		String categoryInfo = "";
		
		if(categories.size() == 0) {
			throw new StorageException("You don't have any categories to show");
		} 
		
		for(Category c : categories.values()) {
			categoryInfo += "------------------------------------------\n";
			categoryInfo += c;
			categoryInfo += "------------------------------------------\n\n";
		}
		
		return categoryInfo;
	}
}