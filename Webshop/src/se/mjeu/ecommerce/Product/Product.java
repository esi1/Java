package se.mjeu.ecommerce.Product;

import se.mjeu.ecommerce.Data.Check;
import se.mjeu.ecommerce.Data.StorageException;

public class Product {
	private final int productId;
	private String productName;
	private String description;
	private String manufacturer;
	private double price;
	private int quantity;
	
	public Product(int productId) {
		this.productId = productId;
		this.productName = "Product name not set yet";
		this.description = "Description not set yet";
		this.manufacturer = "Manufacturer not set yet";
		this.price = 0.0;
		this.quantity = 0;
	}
	
	public int getProductId() {
		return this.productId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) throws StorageException {
		if(productName == null) {
			throw new StorageException("You can't have null as product name");
		} else if(productName.isEmpty()) {
			throw new StorageException("You can't have an empty product name");
		} else if(Check.isNumeric(productName)) {
			throw new StorageException("You can't have a numeric product name");
		} else {
			this.productName = productName;
		}
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) throws StorageException {
		if(description == null) {
			throw new StorageException("You can't have null as description");
		} else if(Check.isNumeric(description)) {
			throw new StorageException("You can't have a numeric description");
		} else {
			this.description = description;
		}
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) throws StorageException {
		if(manufacturer == null) {
			throw new StorageException("You can't have null as manufacturer");
		} else if(manufacturer.isEmpty()) {
			throw new StorageException("You can't have an empty manufacturer");
		} else if(Check.isNumeric(manufacturer)) {
			throw new StorageException("You can't have a numeric manufacturer");
		} else {
			this.manufacturer = manufacturer;
		}
	}
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		
		Product prodTemp = null;
		
		if(obj instanceof Product) {
			prodTemp = (Product) obj;
		}
		
		return (this.productId == prodTemp.productId);
	}
	
	@Override
	public int hashCode() {
		return 37 * this.productId;
	}
	
	@Override
	public String toString() {
		String productInfo = "";
		
		productInfo += "ProductId: " + this.productId + "\n";
		productInfo += "productName: " + this.productName + "\n";
		productInfo += "description: " + this.description + "\n";
		productInfo += "manufacturer: " + this.manufacturer + "\n";
		productInfo += "price: " + this.price + "\n";
		productInfo += "quantity: " + this.quantity + "\n";
		
		return productInfo;
	}
}