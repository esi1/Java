package se.mjeu.ecommerce.Category;

import se.mjeu.ecommerce.Data.Check;
import se.mjeu.ecommerce.Data.StorageException;

public class Category {
	private final int categoryId;
	private String categoryName;
	
	public Category(int categoryId, String categoryName) throws StorageException {
		this.categoryId = categoryId;
		
		if(categoryName == null) {
			throw new StorageException("You can't have null as category name");
		} else if(categoryName.isEmpty()) {
			throw new StorageException("You can't have an empty category name");
		} else if(Check.isNumeric(categoryName)) {
			throw new StorageException("You can't have a numeric category name");
		} else {
			this.categoryName = categoryName;
		}
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) throws StorageException {
		if(categoryName == null) {
			throw new StorageException("You can't have null as category name");
		} else if(categoryName.isEmpty()) {
			throw new StorageException("You can't have an empty category name");
		} else if(Check.isNumeric(categoryName)) {
			throw new StorageException("You can't have a numeric category name");
		} else {
			this.categoryName = categoryName;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		
		Category categoryTemp = null;
		
		if(obj instanceof Category) {
			categoryTemp = (Category) obj;
		}
		
		return (this.categoryId == categoryTemp.categoryId || this.categoryName.equals(categoryTemp.categoryName));
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * this.categoryId;
		result += 37 * this.categoryName.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		String categoryInfo = "";
		
		categoryInfo += "categoryId: " + this.categoryId + "\n";
		categoryInfo += "categoryName: " + this.categoryName + "\n";
		
		return categoryInfo;
	}
}