package se.mjeu.ecommerce.Category;

import se.mjeu.ecommerce.Data.StorageException;

public final class ECommerceServiceCategory implements CategoryRepository {
	private CategoryRepository categoryRepository;

	public ECommerceServiceCategory(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void addCategory(Category category) throws StorageException {
		categoryRepository.addCategory(category);
	}

	@Override
	public void deleteCategory(int id) throws StorageException {
		categoryRepository.deleteCategory(id);
	}

	@Override
	public Category getCategory(int id) throws StorageException {
		return categoryRepository.getCategory(id);
	}

	@Override
	public String getAllCategories() throws StorageException {
		return categoryRepository.getAllCategories();
	}
}
