package se.mjeu.ecommerce.User;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public interface UserRepository {
	public void addUser(User user) throws StorageException;
	public void deleteUser(int id, OrderLineRepository orderLineRepository) throws StorageException;
	public User updateUser(User user) throws StorageException;
	public User getUser(int id) throws StorageException;
	public String getAllUsers() throws StorageException;
}