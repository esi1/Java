package se.mjeu.ecommerce.User;

import se.mjeu.ecommerce.Data.Check;
import se.mjeu.ecommerce.Data.StorageException;

public final class User {
	private final int userId;
	private final String username;
	private final String password;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String country;
	private String phoneNumber;
	private String eMail;
	private int postalCode;
	
	public User (int userId, String username, String password) throws StorageException {
		this.userId = userId;
		
		if(username == null) {
			throw new StorageException("You can't have null as userName");
		} else if(username.isEmpty()) {
			throw new StorageException("You can't have an empty userName");
		} else if(Check.isNumeric(username)) {
			throw new StorageException("You can't have a numeric userName");
		} else {
			this.username = username;
		}
		
		if(password == null) {
			throw new StorageException("You can't have null as password");
		} else if(password.isEmpty()) {
			throw new StorageException("You can't have an empty password");
		} else if(Check.isNumeric(password)) {
			throw new StorageException("You can't have a numeric password");
		} else {
			this.password = password;
		}
		
		this.firstName = "First name not set yet";
		this.lastName = "Last name not set yet";
		this.streetAddress = "Street address not set yet";
		this.postalCode = 0;
		this.city = "City not set yet";
		this.country = "Country not set yet";
		this.phoneNumber = "Phone number not set yet";
		this.eMail = "Email not set yet";
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws StorageException {
		if(firstName == null) {
			throw new StorageException("You can't have null as firstName");
		} else if(firstName.isEmpty()) {
			throw new StorageException("You can't have an empty firstName");
		} else if(Check.isNumeric(firstName)) {
			throw new StorageException("You can't have a numeric firstName");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws StorageException {
		if(lastName == null) {
			throw new StorageException("You can't have null as lastName");
		} else if(lastName.isEmpty()) {
			throw new StorageException("You can't have an empty lastName");
		} else if(Check.isNumeric(lastName)) {
			throw new StorageException("You can't have a numeric lastName");
		} else {
			this.lastName = lastName;
		}
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) throws StorageException {
		if(streetAddress == null) {
			throw new StorageException("You can't have null as streetAddress");
		} else if(streetAddress.isEmpty()) {
			throw new StorageException("You can't have an empty streetAddress");
		} else if(Check.isNumeric(streetAddress)) {
			throw new StorageException("You can't have a numeric streetAddress");
		} else {
			this.streetAddress = streetAddress;
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws StorageException {
		if(city == null) {
			throw new StorageException("You can't have null as city");
		} else if(city.isEmpty()) {
			throw new StorageException("You can't have an empty city");
		} else if(Check.isNumeric(city)) {
			throw new StorageException("You can't have a numeric city");
		} else {
			this.city = city;
		}
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) throws StorageException {
		if(country == null) {
			throw new StorageException("You can't have null as country");
		} else if(country.isEmpty()) {
			throw new StorageException("You can't have an empty country");
		} else if(Check.isNumeric(country)) {
			throw new StorageException("You can't have a numeric country");
		} else {
			this.country = country;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws StorageException {
		if(phoneNumber == null) {
			throw new StorageException("You can't have null as phoneNumber");
		}
		else {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) throws StorageException {
		if(eMail == null) {
			throw new StorageException("You can't have null as eMail");
		}
		else if(Check.isNumeric(eMail)) {
			throw new StorageException("You can't have a numeric eMail");
		} else {
			this.eMail = eMail;
		}
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { return true; }
		
		User userTemp = null;
		
		if(obj instanceof User) {
			userTemp = (User) obj;
		}
		
		return (this.userId == userTemp.userId || (this.username.equals(userTemp.username) && this.password.equals(userTemp.password)));
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * this.userId;
		result += 37 * this.username.hashCode();
		result += 37 * this.password.hashCode();
		
		return result;
	}
	
	@Override
	public String toString() {
		String userInfo = "";
		
		userInfo += "userId: " + this.userId + "\n";
		userInfo += "username: " + this.username + "\n";
		userInfo += "password: " + this.password + "\n";
		userInfo += "firstName: " + this.firstName + "\n";
		userInfo += "lastName: " + this.lastName + "\n";
		userInfo += "streetAddress: " + this.streetAddress + "\n";
		userInfo += "city: " + this.city + "\n";
		userInfo += "country: " + this.country + "\n";
		userInfo += "phoneNumber: " + this.phoneNumber + "\n";
		userInfo += "eMail: " + this.eMail + "\n";
		userInfo += "postalCode: " + this.postalCode + "\n";
		
		return userInfo;
	}
}