package se.mjeu.ecommerce.Category;

import se.mjeu.ecommerce.Data.StorageException;

public interface CategoryRepository {
	public void addCategory(Category category) throws StorageException;
	public void deleteCategory(int id) throws StorageException;
	public Category updateCategory(Category category) throws StorageException;
	public Category getCategory(int id) throws StorageException;
	public String getAllCategories() throws StorageException;
}