package se.mjeu.ecommerce.User;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public final class ECommerceServiceUser implements UserRepository {
	private UserRepository userRepository;
	
	public ECommerceServiceUser(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void addUser(User user) throws StorageException {
		userRepository.addUser(user);
	}

	@Override
	public void deleteUser(int id, OrderLineRepository orderLineRepository) throws StorageException {
		userRepository.deleteUser(id, orderLineRepository);
	}

	@Override
	public User getUser(int id) throws StorageException {
		return userRepository.getUser(id);
	}

	@Override
	public String getAllUsers() throws StorageException {
		return userRepository.getAllUsers();
	}
}
