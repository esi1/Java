package se.mjeu.ecommerce.Main;

import se.mjeu.ecommerce.Category.Category;
import se.mjeu.ecommerce.Category.CategoryRepository;
import se.mjeu.ecommerce.Category.ECommerceServiceCategory;
import se.mjeu.ecommerce.Category.InMemoryCategoryRepository;
import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.Order.ECommerceServiceOrder;
import se.mjeu.ecommerce.Order.InMemoryOrderRepository;
import se.mjeu.ecommerce.Order.Order;
import se.mjeu.ecommerce.Order.OrderRepository;
import se.mjeu.ecommerce.OrderLine.ECommerceServiceOrderLine;
import se.mjeu.ecommerce.OrderLine.InMemoryOrderLineRepository;
import se.mjeu.ecommerce.OrderLine.OrderLine;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;
import se.mjeu.ecommerce.Product.ECommerceServiceProduct;
import se.mjeu.ecommerce.Product.InMemoryProductRepository;
import se.mjeu.ecommerce.Product.Product;
import se.mjeu.ecommerce.Product.ProductRepository;
import se.mjeu.ecommerce.ProductCategory.ECommerceServiceProductCategory;
import se.mjeu.ecommerce.ProductCategory.InMemoryProductCategoryRepository;
import se.mjeu.ecommerce.ProductCategory.ProductCategory;
import se.mjeu.ecommerce.ProductCategory.ProductCategoryRepository;
import se.mjeu.ecommerce.User.ECommerceServiceUser;
import se.mjeu.ecommerce.User.InMemoryUserRepository;
import se.mjeu.ecommerce.User.User;
import se.mjeu.ecommerce.User.UserRepository;

public class Main {
	public static void main(String[] args) {
		try {
			ProductRepository productRepository = new InMemoryProductRepository();
			ProductRepository eCommerceServiceProduct = new ECommerceServiceProduct(productRepository);
			
			eCommerceServiceProduct.addProduct(new Product(1));
			eCommerceServiceProduct.addProduct(new Product(2));
			eCommerceServiceProduct.addProduct(new Product(3));
			
			eCommerceServiceProduct.getProduct(1).setProductName("Jeans");
			eCommerceServiceProduct.getProduct(1).setDescription("Loose fit");
			eCommerceServiceProduct.getProduct(1).setManufacturer("Diesel");
			eCommerceServiceProduct.getProduct(1).setPrice(2.45);
			eCommerceServiceProduct.getProduct(1).setQuantity(34);
			
			eCommerceServiceProduct.getProduct(2).setProductName("Mixer");
			eCommerceServiceProduct.getProduct(2).setDescription("600W");
			eCommerceServiceProduct.getProduct(2).setManufacturer("Braun");
			eCommerceServiceProduct.getProduct(2).setPrice(4.5);
			eCommerceServiceProduct.getProduct(2).setQuantity(61);
			
			eCommerceServiceProduct.getProduct(3).setProductName("Laptop");
			eCommerceServiceProduct.getProduct(3).setDescription("Intel core i7");
			eCommerceServiceProduct.getProduct(3).setManufacturer("Dell");
			eCommerceServiceProduct.getProduct(3).setPrice(4500);
			eCommerceServiceProduct.getProduct(3).setQuantity(102);
			
//			System.out.println(eCommerceServiceProduct.getAllProducts());
			
			// ****************************************************************************************
			
			OrderRepository orderRepository = new InMemoryOrderRepository();
			OrderRepository eCommerceServiceOrder = new ECommerceServiceOrder(orderRepository);
			
			eCommerceServiceOrder.addOrder(new Order(1));
			eCommerceServiceOrder.addOrder(new Order(2));
			
			eCommerceServiceOrder.getOrder(1).setDate("2013-01-12");
			eCommerceServiceOrder.getOrder(1).setPaid(true);
			eCommerceServiceOrder.getOrder(1).setDelivered(true);
			
			eCommerceServiceOrder.getOrder(2).setDate("2014-10-23");
			eCommerceServiceOrder.getOrder(2).setPaid(true);
			eCommerceServiceOrder.getOrder(2).setDelivered(true);
			
//			System.out.println(eCommerceServiceOrder.getAllOrders());
			
			// ****************************************************************************************
			
			UserRepository userRepository = new InMemoryUserRepository();
			UserRepository eCommerceServiceUser = new ECommerceServiceUser(userRepository);
			
			eCommerceServiceUser.addUser(new User(1, "test", "hemma"));
			eCommerceServiceUser.addUser(new User(2, "test2", "hemma2"));
			
			eCommerceServiceUser.getUser(2).setFirstName("Anders");
			eCommerceServiceUser.getUser(2).setLastName("Svensson");
			eCommerceServiceUser.getUser(2).setStreetAddress("Sturegatan 4");
			eCommerceServiceUser.getUser(2).setCity("Stockholm");
			eCommerceServiceUser.getUser(2).setCountry("Sweden");
			eCommerceServiceUser.getUser(2).setPhoneNumber("08 - 563 56 34");
			eCommerceServiceUser.getUser(2).setEMail("anders@yahoo.com");
			eCommerceServiceUser.getUser(2).setPostalCode(11854);
			
			eCommerceServiceUser.getUser(1).setFirstName("Peter");
			eCommerceServiceUser.getUser(1).setLastName("Hamilton");
			eCommerceServiceUser.getUser(1).setStreetAddress("Flamingogatan 17");
			eCommerceServiceUser.getUser(1).setCity("Eskilstuna");
			eCommerceServiceUser.getUser(1).setCountry("Sweden");
			eCommerceServiceUser.getUser(1).setPhoneNumber("08 - 435 23 13");
			eCommerceServiceUser.getUser(1).setEMail("phamilton@gmail.com");
			eCommerceServiceUser.getUser(1).setPostalCode(11475);

//			System.out.println(eCommerceServiceUser.getAllUsers());
			
			// ****************************************************************************************
			
			CategoryRepository categoryRepository = new InMemoryCategoryRepository();
			CategoryRepository eCommerceServiceCategory = new ECommerceServiceCategory(categoryRepository);
			
			eCommerceServiceCategory.addCategory(new Category(1, "Sport"));
			eCommerceServiceCategory.addCategory(new Category(2, "Electronics"));
			
//			System.out.println(eCommerceServiceCategory.getAllCategories());
			
			// ****************************************************************************************
			
			ProductCategoryRepository productCategoryRepository = new InMemoryProductCategoryRepository();
			ProductCategoryRepository eCommerceServiceProductCategory = new ECommerceServiceProductCategory(productCategoryRepository);
			
			eCommerceServiceProductCategory.addProductCategory(new ProductCategory(1, 1), categoryRepository, productRepository);
			eCommerceServiceProductCategory.addProductCategory(new ProductCategory(1, 2), categoryRepository, productRepository);
			
			eCommerceServiceProductCategory.addProductCategory(new ProductCategory(2, 3), categoryRepository, productRepository);
			
//			System.out.println(eCommerceServiceProductCategory.getAllProductCategories());
			
			// ****************************************************************************************
			
			OrderLineRepository orderLineRepository = new InMemoryOrderLineRepository();
			OrderLineRepository eCommerceServiceOrderLine = new ECommerceServiceOrderLine(orderLineRepository);
			
			//OrderLine(int orderLineId, int userId, int orderId, int productId, int quantity)
			eCommerceServiceOrderLine.addOrderLine(new OrderLine(1, 1, 1, 1, 3), userRepository, orderRepository, productRepository);
			eCommerceServiceOrderLine.addOrderLine(new OrderLine(1, 1, 1, 2, 4), userRepository, orderRepository, productRepository);
			eCommerceServiceOrderLine.addOrderLine(new OrderLine(1, 1, 1, 3, 1), userRepository, orderRepository, productRepository);
			
			eCommerceServiceOrderLine.addOrderLine(new OrderLine(2, 2, 2, 2, 6), userRepository, orderRepository, productRepository);
			eCommerceServiceOrderLine.addOrderLine(new OrderLine(2, 2, 2, 1, 5), userRepository, orderRepository, productRepository);
			
			System.out.println(eCommerceServiceOrderLine.getAllOrderLines(productRepository));
		} catch (StorageException e) {
			System.err.println(e.getMessage());
		}
	}
}