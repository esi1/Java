package se.mjeu.ecommerce.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import se.mjeu.ecommerce.Data.StorageException;
import se.mjeu.ecommerce.OrderLine.OrderLine;
import se.mjeu.ecommerce.OrderLine.OrderLineRepository;

public class InMemoryUserRepository implements UserRepository {
private Map<Integer, User> users;
	
	public InMemoryUserRepository() {
		users = new HashMap<>();
	}

	@Override
	public void addUser(User user) throws StorageException {
		if(users.containsValue(user)) {
			throw new StorageException("Either the id is already used, or username and password is already used in the repository");
		} else {
			users.put(user.getUserId(), user);
		}
	}

	@Override
	public void deleteUser(int id, OrderLineRepository orderLineRepository) throws StorageException {
		if(users.containsKey(id)) {
			Iterator<OrderLine> itr = orderLineRepository.listAllOrderLines().iterator();
			
			while(itr.hasNext()) {
				if(itr.next().getUserId() == id) {
					itr.remove();
				}
			}
			
			users.remove(id);
		} else {
			throw new StorageException("You can't delete user with id: " + id + " in the repository");
		}
	}

	@Override
	public User getUser(int id) throws StorageException {
		if(users.containsKey(id)) {
			return users.get(id);
		} else {
			throw new StorageException("You don't have user with id: " + id + " in the repository");
		}
	}

	@Override
	public String getAllUsers() throws StorageException {
		String userInfo = "";
		
		if(users.size() == 0) {
			throw new StorageException("You don't have any users to show");
		} 
		
		for(User u : users.values()) {
			userInfo += "------------------------------------------\n";
			userInfo += u;
			userInfo += "------------------------------------------\n\n";
		}
		
		return userInfo;
	}
}