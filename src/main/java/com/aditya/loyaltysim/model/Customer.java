package com.aditya.loyaltysim.model;

import java.io.Serializable;
/**
 * This is class is used to represent Customer data
 * The JSON would look like below
 *	{
 *		"name": "John",
 *		"email": "name@example.com",
 *		"street": "3rd street MG Road",
 *		"postalCode": "580531",
 *		"city": "Delhi"
 *	}
 */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -3775834207081258396L;

	private String name;
	
	private String email;
	
	private String street;
	
	private int postalCode;
	
	private String city;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

}
