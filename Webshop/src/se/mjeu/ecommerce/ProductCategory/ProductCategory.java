package se.mjeu.ecommerce.ProductCategory;

public class ProductCategory {
	private final int categoryId;
	private final int productId;
	
	public ProductCategory(int categoryId, int productId) {
		this.categoryId = categoryId;
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getProductId() {
		return productId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		
		ProductCategory prodCatTemp = null;
		
		if(obj instanceof ProductCategory) {
			prodCatTemp = (ProductCategory) obj;
		}
		
		return (this.productId == prodCatTemp.productId);
	}
	
	@Override
	public int hashCode() {
		return 37 * this.productId;
	}
	
	@Override
	public String toString() {
		String productCategoryInfo = "";
		
		productCategoryInfo += "categoryId: " + this.categoryId + "\n";
		productCategoryInfo += "productId: " + this.productId + "\n";
		
		return productCategoryInfo;
	}
}